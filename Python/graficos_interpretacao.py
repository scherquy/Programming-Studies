import os
import glob
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

# ===================== CONFIG =====================
OUTDIR = "out_perm_importance"     # pasta onde estão os CSVs real_vs_pred_*.csv
FIGDIR = os.path.join(OUTDIR, "figs")

N_BINS = 10          # bins (quantis) para MAE vs concentração
HIST_BINS = 35       # bins do histograma

# ===================== HELPERS =====================
def ensure_dir(path: str):
    os.makedirs(path, exist_ok=True)

def nice_limits(x, y, pad=0.05):
    m = min(float(np.min(x)), float(np.min(y)))
    M = max(float(np.max(x)), float(np.max(y)))
    r = M - m
    if r == 0:
        r = 1.0
    return m - pad * r, M + pad * r

def rmse(a, b):
    a = np.asarray(a, dtype=float)
    b = np.asarray(b, dtype=float)
    return float(np.sqrt(np.mean((a - b) ** 2)))

def mae(a, b):
    a = np.asarray(a, dtype=float)
    b = np.asarray(b, dtype=float)
    return float(np.mean(np.abs(a - b)))

def r2(a, b):
    a = np.asarray(a, dtype=float)
    b = np.asarray(b, dtype=float)
    ss_res = np.sum((a - b) ** 2)
    ss_tot = np.sum((a - np.mean(a)) ** 2)
    return float(1 - ss_res / ss_tot) if ss_tot != 0 else float("nan")

def get_classes_from_csv_columns(df: pd.DataFrame):
    """
    Infer classes from columns like Real_<class>.
    Returns list of class names.
    """
    classes = []
    for col in df.columns:
        if col.startswith("Real_"):
            cls = col.replace("Real_", "", 1)
            if f"Pred_{cls}" in df.columns:
                classes.append(cls)
    return classes

def bin_stats_quantiles(x_true, abs_err, n_bins=10):
    x_true = np.asarray(x_true, dtype=float)
    abs_err = np.asarray(abs_err, dtype=float)

    qs = np.linspace(0, 1, n_bins + 1)
    edges = np.quantile(x_true, qs)
    edges = np.unique(edges)
    if len(edges) < 3:
        return None, None, None

    centers, means, stds = [], [], []
    for i in range(len(edges) - 1):
        lo, hi = edges[i], edges[i + 1]
        # último bin inclui a borda superior
        if i == len(edges) - 2:
            mask = (x_true >= lo) & (x_true <= hi)
        else:
            mask = (x_true >= lo) & (x_true < hi)

        if np.sum(mask) < 2:
            continue

        centers.append(0.5 * (lo + hi))
        means.append(np.mean(abs_err[mask]))
        stds.append(np.std(abs_err[mask]))

    if len(centers) < 2:
        return None, None, None

    return np.array(centers), np.array(means), np.array(stds)

# ===================== PLOTS =====================
def plot_scatter_real_vs_pred(df, cls, outpath):
    x = df[f"Real_{cls}"].to_numpy(dtype=float)
    y = df[f"Pred_{cls}"].to_numpy(dtype=float)

    m2, M2 = nice_limits(x, y)
    r2v = r2(x, y)
    maev = mae(x, y)
    rmsev = rmse(x, y)

    plt.figure(figsize=(5.6, 5.2))
    plt.scatter(x, y, s=14, alpha=0.65)
    plt.plot([m2, M2], [m2, M2], linewidth=1.6)  # y=x
    plt.xlim(m2, M2)
    plt.ylim(m2, M2)
    plt.xlabel(f"Real {cls} (%)")
    plt.ylabel(f"Pred {cls} (%)")
    plt.title(f"Real vs Pred — {cls}\n$R^2$={r2v:.4f} | MAE={maev:.3f} | RMSE={rmsev:.3f}")
    plt.grid(True, alpha=0.25)
    plt.tight_layout()
    plt.savefig(outpath, dpi=350, bbox_inches="tight")
    plt.close()

def plot_residuals_vs_real(df, cls, outpath):
    x = df[f"Real_{cls}"].to_numpy(dtype=float)
    y = df[f"Pred_{cls}"].to_numpy(dtype=float)
    res = y - x

    plt.figure(figsize=(6.4, 4.2))
    plt.scatter(x, res, s=14, alpha=0.65)
    plt.axhline(0.0, linewidth=1.4)
    plt.xlabel(f"Real {cls} (%)")
    plt.ylabel(f"Residual (Pred - Real) {cls} (%)")
    plt.title(f"Residuals vs Real — {cls}")
    plt.grid(True, alpha=0.25)
    plt.tight_layout()
    plt.savefig(outpath, dpi=350, bbox_inches="tight")
    plt.close()

def plot_hist_abs_error(df, cls, outpath, bins=35):
    x = df[f"Real_{cls}"].to_numpy(dtype=float)
    y = df[f"Pred_{cls}"].to_numpy(dtype=float)
    e = np.abs(x - y)

    plt.figure(figsize=(6.4, 4.2))
    plt.hist(e, bins=bins, alpha=0.85)
    plt.xlabel(f"|Error| {cls} (%)")
    plt.ylabel("Count")
    plt.title(f"Absolute Error Distribution — {cls}\nmean={np.mean(e):.3f} | median={np.median(e):.3f}")
    plt.grid(True, alpha=0.25)
    plt.tight_layout()
    plt.savefig(outpath, dpi=350, bbox_inches="tight")
    plt.close()

def plot_abs_error_binned(df, cls, outpath, n_bins=10):
    x = df[f"Real_{cls}"].to_numpy(dtype=float)
    y = df[f"Pred_{cls}"].to_numpy(dtype=float)
    e = np.abs(x - y)

    centers, means, stds = bin_stats_quantiles(x, e, n_bins=n_bins)
    if centers is None:
        plt.figure(figsize=(6.4, 4.2))
        plt.text(0.5, 0.5, "Not enough unique values\nto compute binned stats.",
                 ha="center", va="center")
        plt.axis("off")
        plt.tight_layout()
        plt.savefig(outpath, dpi=300, bbox_inches="tight")
        plt.close()
        return

    plt.figure(figsize=(6.4, 4.2))
    plt.plot(centers, means, marker="o", linewidth=1.8)
    plt.fill_between(centers, means - stds, means + stds, alpha=0.2)
    plt.xlabel(f"Real {cls} (%) — bin centers (quantiles)")
    plt.ylabel(f"Mean |Error| {cls} (%)")
    plt.title(f"Mean Absolute Error vs Concentration — {cls}")
    plt.grid(True, alpha=0.25)
    plt.tight_layout()
    plt.savefig(outpath, dpi=350, bbox_inches="tight")
    plt.close()

def plot_sum_real_vs_pred_if_available(df, outpath):
    # se já existir no CSV, usa; se não, tenta construir pela soma de Real_*/Pred_*
    if "Real_sum" in df.columns and "Pred_sum" in df.columns:
        x = df["Real_sum"].to_numpy(dtype=float)
        y = df["Pred_sum"].to_numpy(dtype=float)
    else:
        classes = get_classes_from_csv_columns(df)
        if not classes:
            return
        x = np.zeros(len(df), dtype=float)
        y = np.zeros(len(df), dtype=float)
        for cls in classes:
            x += df[f"Real_{cls}"].to_numpy(dtype=float)
            y += df[f"Pred_{cls}"].to_numpy(dtype=float)

    m2, M2 = nice_limits(x, y)
    r2v = r2(x, y)
    maev = mae(x, y)
    rmsev = rmse(x, y)

    plt.figure(figsize=(5.6, 5.2))
    plt.scatter(x, y, s=14, alpha=0.65)
    plt.plot([m2, M2], [m2, M2], linewidth=1.6)
    plt.xlim(m2, M2)
    plt.ylim(m2, M2)
    plt.xlabel("Real sum (%)")
    plt.ylabel("Pred sum (%)")
    plt.title(f"Real vs Pred (Sum)\n$R^2$={r2v:.4f} | MAE={maev:.3f} | RMSE={rmsev:.3f}")
    plt.grid(True, alpha=0.25)
    plt.tight_layout()
    plt.savefig(outpath, dpi=350, bbox_inches="tight")
    plt.close()

# ===================== MAIN =====================
def main():
    ensure_dir(FIGDIR)

    csvs = sorted(glob.glob(os.path.join(OUTDIR, "real_vs_pred_*.csv")))
    if not csvs:
        raise FileNotFoundError(f"Nenhum CSV real_vs_pred_*.csv encontrado em: {OUTDIR}")

    print(f"[OK] Encontrados {len(csvs)} CSV(s). Gerando figuras...")

    for csv_path in csvs:
        name = os.path.splitext(os.path.basename(csv_path))[0]
        out_sub = os.path.join(FIGDIR, name)
        ensure_dir(out_sub)

        df = pd.read_csv(csv_path)

        classes = get_classes_from_csv_columns(df)
        if not classes:
            print(f"[WARN] {name}: não achei colunas Real_*/Pred_*; pulando.")
            continue

        # Figuras por classe
        for cls in classes:
            plot_scatter_real_vs_pred(df, cls, os.path.join(out_sub, f"scatter_real_vs_pred_{cls}.png"))
            plot_residuals_vs_real(df, cls, os.path.join(out_sub, f"residuals_vs_real_{cls}.png"))
            plot_hist_abs_error(df, cls, os.path.join(out_sub, f"hist_abs_error_{cls}.png"), bins=HIST_BINS)
            plot_abs_error_binned(df, cls, os.path.join(out_sub, f"mae_vs_conc_binned_{cls}.png"), n_bins=N_BINS)

        # Soma
        plot_sum_real_vs_pred_if_available(df, os.path.join(out_sub, "scatter_sum_real_vs_pred.png"))

        print(f"[OK] Figuras salvas em: {out_sub}")

    print("\nConcluído!")

if __name__ == "__main__":
    main()
