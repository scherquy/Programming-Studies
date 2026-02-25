from sklearn.model_selection import GridSearchCV
from sklearn.neural_network import MLPRegressor
import os
from libs.process_txt_files import *
from libs.data_split_treat import *
from libs.visualization import *
from sklearn.model_selection import train_test_split



os.environ["LOKY_MAX_CPU_COUNT"] = "6" # Na real não é esse o número de núcleos, mas azar


# ---- Definição de variáveis ----
path_to_folder = "C:/Users/labor/OneDrive/pyspectrumML/Aldi-sal"

# Definição das classes
classes = ["Aldicarbe",
           "Sal"]


plotar_arquivos(path_to_folder)

# Dados em formato de DataFrame
df = dataF(path_to_folder, dclass="multi")


df2 = noise(df, 500, 0.01)
df2 = area_norm(df2)

X = np.vstack(df2["intensidades"].values)  # matrix np
y = df2.drop(columns=["frequencias", "intensidades"]).fillna(0).values  # Tira tudo, fica só as classes

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Definição da rede base
mlp = MLPRegressor(max_iter=250, random_state=42)

# Grade de hiperparâmetros
param_grid = {
    'hidden_layer_sizes': [(200, 200), (200, 200, 200), (200, 200, 200, 200), (200, 200, 200, 200, 200),(100, 100), (100, 100, 100), (100, 100, 100, 100), (100, 100, 100, 100, 100),(50, 50), (50, 50, 50), (50, 50, 50, 50), (50, 50, 50, 50, 50)],
    'activation': ['relu', 'identity'],
    'alpha': [0.0001, 0.001, 0.01],  # Regularização L2
    'solver': ['adam'],
}

# Otimização
grid_search = GridSearchCV(mlp, param_grid, cv=3, scoring='r2', verbose=2, n_jobs=-1)
grid_search.fit(X_train, y_train)

# Melhores parâmetros encontrados
print("Melhores parâmetros:", grid_search.best_params_)
print("Melhor score:", grid_search.best_score_)

# Teste no conjunto de teste
y_pred = grid_search.best_estimator_.predict(X_test)
