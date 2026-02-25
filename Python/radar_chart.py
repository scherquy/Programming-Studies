import numpy as np
import matplotlib.pyplot as plt

# Seus resultados reais
results = {
    'relu': {
        'MAE': [0.54482871, 0.44512414],
        'MSE': [0.73627151, 0.61773068],
        'R²': [0.99767312, 0.99804775]
    },
    'identity': {
        'MAE': [1.98203329, 1.99259181],
        'MSE': [12.62232171, 12.66798416],
        'R²': [0.96010898, 0.95996467]
    }
}

activation_functions = list(results.keys())
classes = ["Aldicarbe", "Sal"]
metrics = ["MAE", "MSE", "R²"]
angles = np.linspace(0, 2 * np.pi, len(metrics), endpoint=False).tolist()
angles += angles[:1]  # fecha o círculo

def normalize_metric(metric_values, invert=False):
    """
    Normaliza valores de uma métrica (por classe), opcionalmente invertendo (útil para R²).
    """
    vals = np.array(metric_values)
    if invert:
        vals = 1 - vals
    max_val = vals.max() if vals.max() > 0 else 1
    return (vals / max_val).tolist()

# === Gera um radar chart por classe ===
for class_idx, class_name in enumerate(classes):
    fig, ax = plt.subplots(figsize=(8, 6), subplot_kw=dict(polar=True))

    for activation in activation_functions:
        mae = results[activation]["MAE"][class_idx]
        mse = results[activation]["MSE"][class_idx]
        r2 = results[activation]["R²"][class_idx]

        # Normalização (r2 invertido)
        values = [
            mae,
            mse,
            1 - r2  # inverte para coerência visual: menor é melhor
        ]

        # Normaliza dentro de cada métrica
        all_mae = [results[act]["MAE"][class_idx] for act in activation_functions]
        all_mse = [results[act]["MSE"][class_idx] for act in activation_functions]
        all_r2 = [results[act]["R²"][class_idx] for act in activation_functions]

        norm_mae = mae / max(all_mae)
        norm_mse = mse / max(all_mse)
        norm_r2 = (1 - r2) / max([1 - r for r in all_r2])

        norm_values = [norm_mae, norm_mse, norm_r2]
        norm_values += norm_values[:1]  # fecha o polígono

        ax.plot(angles, norm_values, label=activation, linewidth=2)
        ax.fill(angles, norm_values, alpha=0.1)

    ax.set_title(f"Radar Chart – Classe: {class_name}", fontsize=14, pad=20)
    ax.set_thetagrids(np.degrees(angles[:-1]), metrics, fontsize=12)
    ax.set_ylim(0, 1)
    ax.legend(loc='upper right', bbox_to_anchor=(1.3, 1.1))
    ax.grid(True)

    plt.tight_layout()
    plt.show()