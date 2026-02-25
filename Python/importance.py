"""
Permutation Importance por janelas espectrais (Group Permutation) para MLPRegressor
- Lê seus TXT via funções existentes em libs/
- Faz noise + area_norm (como no seu pipeline)
- Treina MLPRegressor (ReLU e Identity, opcional)
- Calcula permutation importance por janelas (ΔR² médio nas 2 saídas)
- Plota e salva figura (PNG) + CSV com importâncias

⚠️ Ajuste:
- path_to_folder
- nomes das funções das suas libs, se necessário
"""

# -------------------- IMPORTS --------------------
from libs.process_txt_files import *
from libs.data_split_treat import *
from libs.visualization import *

import os
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neural_network import MLPRegressor

from sklearn.metrics import mean_absolute_error, mean_squared_error, r2_score

# -------------------- CONFIG --------------------
os.environ["LOKY_MAX_CPU_COUNT"] = "6"

path_to_folder = r"C:/Users/paiva/OneDrive/pyspectrumML/dados_venenos_sal_final"

classes = ["Aldicarbe", "Dicamba"]

# Pré-process / Augmentation
NOISE_N = 100        # (do seu noise(df, 100, 0.01))
NOISE_STD = 0.01
SHOW_NOISE = False   # True para visualizar

# Split
TEST_SIZE = 0.2
RANDOM_STATE = 42

# MLP
HIDDEN = (200, 200, 200, 200)  # use o melhor do artigo; pode trocar
MAX_ITER = 300                 # melhor que 50 para convergir; ajuste se quiser
ALPHA = 0.001
ACTIVATION = "relu"            # "relu" ou "identity"
SOLVER = "adam"

# Permutation importance
WINDOW_WIDTH = 20   # cm^-1 (tamanho da janela)
N_REPEATS = 15
OUTDIR = "out_perm_importance"

def select_topk_windows(imp, bounds, centers, k=10):
    idx_sorted = np.argsort(-imp)  # desc
    top_idx = idx_sorted[:k]
    info = []
    for i in top_idx:
        s, e = bounds[i]
        info.append((i, float(centers[i]), float(s), float(e), float(imp[i])))
    return top_idx, pd.DataFrame(info, columns=["idx", "center", "win_start", "win_end", "delta_r2"])

def build_X_from_windows(X, windows, selected_window_indices):
    cols = np.concatenate([windows[i] for i in selected_window_indices])
    cols = np.unique(cols)  # garante sem repetição e ordenado
    return X[:, cols], cols

def eval_multioutput(y_true, y_pred, classes):
    mae = mean_absolute_error(y_true, y_pred, multioutput="raw_values")
    mse = mean_squared_error(y_true, y_pred, multioutput="raw_values")
    r2 = r2_score(y_true, y_pred, multioutput="raw_values")
    out = {
        "R2_mean": float(np.mean(r2))
    }
    for i, c in enumerate(classes):
        out[f"{c}_MAE"] = float(mae[i])
        out[f"{c}_MSE"] = float(mse[i])
        out[f"{c}_R2"] = float(r2[i])
    return out


def plot_importance(centers, imp, imp_std, bounds,
                                    outdir, window_width, activation,
                                    top_k=5, dpi=400):
    """
    Plota:
      - curva ΔR²
      - faixa ± std
      - marca e anota automaticamente as Top-K janelas (maiores ΔR²)
    """
    os.makedirs(outdir, exist_ok=True)

    centers = np.asarray(centers).astype(float)
    imp = np.asarray(imp).astype(float)
    imp_std = np.asarray(imp_std).astype(float)

    # Ordena por centro para plot contínuo
    order = np.argsort(centers)
    c = centers[order]
    v = imp[order]
    s = imp_std[order]

    plt.figure(figsize=(11, 4.2))
    plt.plot(c, v, linewidth=2.0)
    plt.fill_between(c, v - s, v + s, alpha=0.20)

    plt.xlabel("Raman shift (cm$^{-1}$)")
    plt.ylabel("Importance ($\\Delta R^2$ médio)")
    plt.title(f"Grouped permutation importance (window width={window_width} cm$^{{-1}}$) — MLP ({activation})")
    plt.grid(True, alpha=0.25)

    # Seleciona top_k pelo ΔR² (no vetor original)
    top_idx = np.argsort(-imp)[:top_k]

    ymax = float(np.max(v + s))
    ypad = 0.18 * ymax

    # Alterna offsets do texto para evitar sobreposição
    offsets = [120, -120, 160, -160, 200, -200]

    for j, idx in enumerate(top_idx):
        x0 = float(centers[idx])
        y0 = float(imp[idx])
        sd0 = float(imp_std[idx])
        b0, b1 = bounds[idx]

        plt.axvline(x0, linestyle="--", alpha=0.35)

        dx = offsets[j % len(offsets)]
        x_text = x0 + dx
        y_text = min(y0 + ypad, 0.95 * ymax)

        label = (
            f"{int(round(x0))} cm$^{{-1}}$  [{int(round(b0))}–{int(round(b1))})\n"
            f"$\\Delta R^2$={y0:.4f}±{sd0:.4f}"
        )

        top_idx = np.argsort(-imp)[:top_k]

# Anota com espaçamento automático
        annotate_topk_spread(
            ax=plt.gca(),
            centers=centers,
            imp=imp,
            imp_std=imp_std,
            bounds=bounds,
            top_idx=top_idx,
            min_dx_cm1=80,       # aumente se ainda ficar junto (ex.: 120)
            base_dy_pts=28,      # altura base
            step_dy_pts=16,      # quanto sobe a cada empilhamento
            dx_pts_left=-100,    # deslocamento lateral
            dx_pts_right=160
        )

    plt.ylim(0.0, 1.05 * ymax)
    plt.tight_layout()

    out_png = os.path.join(outdir, f"perm_importance{top_k}_{window_width}cm-1_{activation}.png")
    plt.savefig(out_png, dpi=dpi, bbox_inches="tight")
    plt.show()

    print(f"[OK] Figura publicável (Top-{top_k}) salva em: {out_png}")
    return out_png


def annotate_topk_spread(ax, centers, imp, imp_std, bounds, top_idx,
                        min_dx_cm1=80, base_dy_pts=30, step_dy_pts=18,
                        dx_pts_left=-140, dx_pts_right=140):
    """
    Anota pontos top_idx no eixo ax, espalhando labels para evitar sobreposição.

    Estratégia:
      - ordena por centro (x)
      - se centros estiverem a menos de min_dx_cm1, aumenta dy (empilha)
      - alterna dx (esquerda/direita)
      - seta curva (rad) aumenta um pouco quando empilha
    """
    # ordena top_idx por x (centro)
    top_idx = list(top_idx)
    top_idx.sort(key=lambda i: centers[i])

    last_x = None
    stack_level = 0
    toggle = 1  # alterna lado

    for j, idx in enumerate(top_idx):
        x0 = float(centers[idx])
        y0 = float(imp[idx])
        sd0 = float(imp_std[idx])
        b0, b1 = bounds[idx]

        # checa proximidade em x com o anterior
        if last_x is not None and abs(x0 - last_x) < min_dx_cm1:
            stack_level += 1
        else:
            stack_level = 0

        last_x = x0

        # offset em pontos (melhor do que offset em cm^-1 no eixo)
        dy = base_dy_pts + stack_level * step_dy_pts

        # alterna lado para diminuir cruzamento
        dx = dx_pts_right if toggle > 0 else dx_pts_left
        toggle *= -1

        # marca linha vertical discreta
        ax.axvline(x0, linestyle="--", alpha=0.25, linewidth=1.2)

        label = (
            f"{int(round(x0))} cm$^{{-1}}$  [{int(round(b0))}–{int(round(b1))})\n"
            f"$\\Delta R^2$={y0:.4f}±{sd0:.4f}"
        )

        # seta com leve curvatura (maior curvatura quando empilha mais)
        rad = 0.15 + 0.05 * stack_level
        ax.annotate(
            label,
            xy=(x0, y0),
            xytext=(dx, dy),
            textcoords="offset points",
            ha="left" if dx > 0 else "right",
            va="bottom",
            fontsize=9,
            bbox=dict(boxstyle="round,pad=0.25", fc="white", ec="none", alpha=0.75),
            arrowprops=dict(arrowstyle="->", lw=1.2, connectionstyle=f"arc3,rad={rad}")
        )

# -------------------- FUNÇÕES AUXILIARES --------------------
def r2_mean(y_true, y_pred) -> float:
    """R² médio nas saídas (multioutput)."""
    r2_each = r2_score(y_true, y_pred, multioutput="raw_values")
    return float(np.mean(r2_each))

def save_pred_comparison_csv(
    outdir: str,
    tag: str,
    y_true: np.ndarray,
    y_pred: np.ndarray,
    classes: list[str],
    extra_info: dict | None = None
):
    """
    Salva um CSV com valores reais vs preditos (multioutput).
    - tag: string para diferenciar (ex: 'baseline_all', 'top3', etc.)
    - extra_info: dicionário opcional para incluir metadados no nome/colunas
    """
    os.makedirs(outdir, exist_ok=True)

    df = pd.DataFrame()

    # Reais e preditos por classe
    for i, c in enumerate(classes):
        df[f"Real_{c}"] = y_true[:, i]
        df[f"Pred_{c}"] = y_pred[:, i]
        df[f"AbsErr_{c}"] = np.abs(y_true[:, i] - y_pred[:, i])

    # Erro médio por amostra (média das classes)
    abs_err_cols = [f"AbsErr_{c}" for c in classes]
    df["AbsErr_mean"] = df[abs_err_cols].mean(axis=1)

    # (Opcional) soma total real vs predito (ajuda em mistura/consistência)
    df["Real_sum"] = y_true.sum(axis=1)
    df["Pred_sum"] = y_pred.sum(axis=1)
    df["AbsErr_sum"] = np.abs(df["Real_sum"] - df["Pred_sum"])

    # Metadados opcionais
    if extra_info:
        for k, v in extra_info.items():
            df[k] = v

    out_csv = os.path.join(outdir, f"real_vs_pred_{tag}.csv")
    df.to_csv(out_csv, index=False)
    print(f"[OK] Salvo: {out_csv}")
    return out_csv

def make_windows(freq: np.ndarray, width: float = 50.0):
    """
    Cria janelas contíguas de Raman shift.
    Retorna:
      - windows: lista de arrays de índices de colunas (features) pertencentes à janela
      - centers: centro (cm^-1) de cada janela
      - bounds: tuplas (start, end) para salvar em CSV
    """
    freq = np.asarray(freq).astype(float)
    fmin, fmax = float(np.min(freq)), float(np.max(freq))
    starts = np.arange(fmin, fmax, width)

    windows, centers, bounds = [], [], []
    for s in starts:
        e = s + width
        idx = np.where((freq >= s) & (freq < e))[0]
        if idx.size > 0:
            windows.append(idx)
            centers.append((s + e) / 2.0)
            bounds.append((s, e))
    return windows, np.array(centers), bounds

def grouped_permutation_importance(model, X: np.ndarray, y: np.ndarray,
                                   groups, n_repeats: int = 10,
                                   random_state: int = 42):
    """
    Permutation importance por grupos (janelas):
    embaralha simultaneamente todas as colunas de uma janela (grupo),
    mede queda no score (ΔR² = R²_base - R²_perm).
    """
    rng = np.random.RandomState(random_state)

    base_pred = model.predict(X)
    base_score = r2_mean(y, base_pred)

    imp = np.zeros(len(groups), dtype=float)
    imp_std = np.zeros(len(groups), dtype=float)

    for g, idx in enumerate(groups):
        drops = []
        for _ in range(n_repeats):
            Xp = X.copy()
            perm = rng.permutation(X.shape[0])
            Xp[:, idx] = Xp[perm][:, idx]

            predp = model.predict(Xp)
            scorep = r2_mean(y, predp)
            drops.append(base_score - scorep)

        imp[g] = float(np.mean(drops))
        imp_std[g] = float(np.std(drops))

    return base_score, imp, imp_std

# -------------------- PIPELINE PRINCIPAL --------------------
def main():
    os.makedirs(OUTDIR, exist_ok=True)

    # 1) Carregar dados
    # (mantém como no seu script)
    plotar_arquivos(path_to_folder)
    df = dataF(path_to_folder, dclass="multi")

    # 2) Augmentation + normalização (como você faz)
    df2 = noise(df, NOISE_N, NOISE_STD, show=SHOW_NOISE)
    df2 = area_norm(df2)

    # 3) Montar X e y
    X = np.vstack(df2["intensidades"].values)
    y = df2.drop(columns=["frequencias", "intensidades"]).fillna(0).values

    # Frequências (assume o mesmo eixo para todos)
    freq = np.array(df2["frequencias"].iloc[0], dtype=float)
    if X.shape[1] != freq.shape[0]:
        raise ValueError(f"Dimensões incompatíveis: X tem {X.shape[1]} colunas, "
                         f"freq tem {freq.shape[0]} valores.")

    print("X:", X.shape, "| y:", y.shape, "| freq:", freq.shape)

    # 4) Split
    X_train, X_test, y_train, y_test = train_test_split(
        X, y, test_size=TEST_SIZE, random_state=RANDOM_STATE
    )

    # 5) Scaling (recomendado p/ MLP)
    scaler = StandardScaler()
    X_train_s = scaler.fit_transform(X_train)
    X_test_s = scaler.transform(X_test)

    # 6) Treinar MLP
    mlp = MLPRegressor(
        hidden_layer_sizes=HIDDEN,
        activation=ACTIVATION,
        solver=SOLVER,
        max_iter=MAX_ITER,
        random_state=RANDOM_STATE,
        alpha=ALPHA,
        verbose=False
        # Você pode adicionar early_stopping=True, validation_fraction=0.1, n_iter_no_change=10
    )

    print("\nTreinando MLPRegressor...")
    mlp.fit(X_train_s, y_train)
    y_pred = mlp.predict(X_test_s)

    # 7) Métricas
    mae = mean_absolute_error(y_test, y_pred, multioutput="raw_values")
    mse = mean_squared_error(y_test, y_pred, multioutput="raw_values")
    r2_each = r2_score(y_test, y_pred, multioutput="raw_values")
    r2_avg = float(np.mean(r2_each))

    print("\n=== MÉTRICAS (teste) ===")
    for i, c in enumerate(classes):
        print(f"{c}: MAE={mae[i]:.6f} | MSE={mse[i]:.6f} | R²={r2_each[i]:.6f}")
    print(f"R² médio (2 saídas): {r2_avg:.6f}")

    # 8) Janelas
    windows, centers, bounds = make_windows(freq, width=WINDOW_WIDTH)
    print(f"\nCriadas {len(windows)} janelas de {WINDOW_WIDTH} cm^-1.")

    # 9) Permutation importance por janelas
    print("\nCalculando permutation importance (grouped)...")
    base_score, imp, imp_std = grouped_permutation_importance(
        model=mlp,
        X=X_test_s,
        y=y_test,
        groups=windows,
        n_repeats=N_REPEATS,
        random_state=RANDOM_STATE
    )

    print(f"R² médio base: {base_score:.6f}")
    top = np.argsort(-imp)[:10]
    print("\nTop 10 janelas mais importantes (ΔR²):")
    for k in top:
        s, e = bounds[k]
        print(f"[{s:.0f}, {e:.0f}) cm^-1 | centro={centers[k]:.0f} | ΔR²={imp[k]:.6f} ± {imp_std[k]:.6f}")

    # 10) Salvar CSV
    out_csv = os.path.join(OUTDIR, f"perm_importance_windows_{WINDOW_WIDTH}cm-1_{ACTIVATION}.csv")
    df_imp = pd.DataFrame({
        "win_start": [b[0] for b in bounds],
        "win_end":   [b[1] for b in bounds],
        "center":    centers,
        "delta_r2_mean": imp,
        "delta_r2_std":  imp_std
    }).sort_values("delta_r2_mean", ascending=False)
    df_imp.to_csv(out_csv, index=False)
    print(f"\nCSV salvo em: {out_csv}")

    # 11) Plot e salvar figura
    out_png = os.path.join(OUTDIR, f"perm_importance_{WINDOW_WIDTH}cm-1_{ACTIVATION}.png")
    plt.figure(figsize=(11, 4))
    # ordenar por centro para plot contínuo
    order = np.argsort(centers)
    plt.plot(centers[order], imp[order])
    plt.fill_between(centers[order],
                     (imp - imp_std)[order],
                     (imp + imp_std)[order],
                     alpha=0.2)
    plt.xlabel("Raman shift (cm$^{-1}$)")
    plt.ylabel("Importance (ΔR$^2$ médio)")
    plt.title(f"Grouped permutation importance (Window width={WINDOW_WIDTH} cm$^{{-1}}$) — MLP ({ACTIVATION})")
    plt.grid(False, alpha=0.3)
    plt.tight_layout()
    plt.savefig(out_png, dpi=300)
    plt.show()
    print(f"Figura salva em: {out_png}")

    # 12) (Opcional) comparar real vs predito (primeiras N linhas)
    n = 30
    df_cmp = pd.DataFrame(y_test, columns=[f"Real_{c}" for c in classes])
    for i, c in enumerate(classes):
        df_cmp[f"Pred_{c}"] = y_pred[:, i]
    out_cmp = os.path.join(OUTDIR, f"real_vs_pred_{ACTIVATION}.csv")
    df_cmp.head(n).to_csv(out_cmp, index=False)
    print(f"\nComparação (head {n}) salva em: {out_cmp}")

    plot_importance(
    centers=centers,
    imp=imp,
    imp_std=imp_std,
    bounds=bounds,
    outdir=OUTDIR,
    window_width=WINDOW_WIDTH,
    activation=ACTIVATION,
    top_k=5,
    dpi=400
    )

    # --- 2.1) split limpo: train/val/test ---
    X_tr, X_te, y_tr, y_te = train_test_split(X, y, test_size=0.2, random_state=42)
    X_tr2, X_val, y_tr2, y_val = train_test_split(X_tr, y_tr, test_size=0.25, random_state=42)
    # => fica 60% train, 20% val, 20% test

    # --- 2.2) treina MLP baseline (todas as features) no train ---
    sc_all = StandardScaler()
    X_tr2_s = sc_all.fit_transform(X_tr2)
    X_val_s = sc_all.transform(X_val)
    X_te_s  = sc_all.transform(X_te)

    mlp_all = MLPRegressor(
        hidden_layer_sizes=(200, 200, 200, 200),
        activation="relu",
        solver="adam",
        max_iter=300,
        alpha=0.001,
        random_state=42
    )
    mlp_all.fit(X_tr2_s, y_tr2)

    # baseline no test
    pred_te_all = mlp_all.predict(X_te_s)
    save_pred_comparison_csv(
    outdir=OUTDIR,
    tag="baseline_all_features",
    y_true=y_te,
    y_pred=pred_te_all,
    classes=classes
)

    baseline_metrics = eval_multioutput(y_te, pred_te_all, classes)
    print("\nBaseline (todas as features) no TEST:")
    print(pd.Series(baseline_metrics))

    # --- 2.3) importance calculada no VAL (sem tocar o test) ---
    base_score_val, imp_val, imp_std_val = grouped_permutation_importance(
        model=mlp_all,
        X=X_val_s,
        y=y_val,
        groups=windows,
        n_repeats=15,
        random_state=42
    )

    print("\nR² médio base no VAL:", base_score_val)

    # --- 2.4) selecionar Top-K janelas e re-treinar só com elas ---
    for K in [3, 5, 10, 20]:
        top_idx, df_top = select_topk_windows(imp_val, bounds, centers, k=K)
        print(f"\nTop-{K} janelas (selecionadas via VAL):")
        print(df_top)

        # reduz X
        X_tr2_red, cols_red = build_X_from_windows(X_tr2, windows, top_idx)
        X_val_red, _ = build_X_from_windows(X_val, windows, top_idx)
        X_te_red,  _ = build_X_from_windows(X_te,  windows, top_idx)

        # scaler novo (só nas features reduzidas)
        sc_red = StandardScaler()
        X_tr2_red_s = sc_red.fit_transform(X_tr2_red)
        X_val_red_s = sc_red.transform(X_val_red)
        X_te_red_s  = sc_red.transform(X_te_red)

        mlp_red = MLPRegressor(
            hidden_layer_sizes=(200, 200, 200, 200),
            activation="relu",
            solver="adam",
            max_iter=300,
            alpha=0.001,
            random_state=42
        )
        mlp_red.fit(X_tr2_red_s, y_tr2)

        pred_te_red = mlp_red.predict(X_te_red_s)
        red_metrics = eval_multioutput(y_te, pred_te_red, classes)
        # Se você quiser guardar também quais janelas foram usadas no arquivo:
        windows_used_str = ";".join([f"{bounds[i][0]:.0f}-{bounds[i][1]:.0f}" for i in top_idx])

        save_pred_comparison_csv(
            outdir=OUTDIR,
            tag=f"top{K}_windows",
            y_true=y_te,
            y_pred=pred_te_red,
            classes=classes,
            extra_info={"windows_used": windows_used_str}
        )


        print(f"\nMLP reduzido (Top-{K} janelas) no TEST:")
        print(pd.Series(red_metrics))

        # comparação rápida
        print(f"Comparação R²_mean (TEST): baseline={baseline_metrics['R2_mean']:.6f} | top{K}={red_metrics['R2_mean']:.6f}")


if __name__ == "__main__":
    main()

