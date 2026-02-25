from libs.process_txt_files import *
from libs.data_split_treat import *
from libs.visualization import *
import matplotlib.pyplot as plt
from sklearn.decomposition import PCA
import seaborn as sns
from mpl_toolkits.mplot3d import Axes3D
from sklearn.svm import SVC
from sklearn.model_selection import train_test_split
from sklearn.metrics import classification_report, accuracy_score
from sklearn.model_selection import GridSearchCV
from sklearn.linear_model import LogisticRegression
from sklearn.neighbors import KNeighborsClassifier
from sklearn.ensemble import RandomForestClassifier
# from xgboost import XGBClassifier ?
from sklearn.naive_bayes import GaussianNB
from sklearn.neural_network import MLPClassifier
from sklearn.metrics import accuracy_score, f1_score, classification_report, confusion_matrix
import pybaselines as pbl
import pandas as pd
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsRegressor
from sklearn.neural_network import MLPRegressor
from sklearn.metrics import mean_squared_error
import os
from sklearn.metrics import mean_absolute_error
from sklearn.metrics import r2_score


os.environ["LOKY_MAX_CPU_COUNT"] = "6" # Na real não é esse o número de núcleos, mas azar, funciona


# ---- Definição de variáveis ----
path_to_folder = "C:/Users/paiva/OneDrive/pyspectrumML/dados_venenos_sal_final"

# Definição das classes
classes = ["Aldicarbe",
           "Dicamba"]


plotar_arquivos(path_to_folder)

# Dados em formato de DataFrame
df = dataF(path_to_folder, dclass="multi")


df2 = noise(df, 100, 0.01, show = True)
df2 = area_norm(df2)

X = np.vstack(df2["intensidades"].values)  # matrix np
y = df2.drop(columns=["frequencias", "intensidades"]).fillna(0).values  # Tira tudo, fica só as classes


print(y)

# Treino e teste
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)


knn = KNeighborsRegressor(n_neighbors=6 , weights="distance")  # Tem que muda o n_neighbors pra c o número total de classes - 1
knn.fit(X_train, y_train)

# Prediciones
y_pred = knn.predict(X_test)

# Avaliação de erros
mae = mean_absolute_error(y_test, y_pred, multioutput='raw_values')
print("Erro médio absoluto por classe:", mae)
r2 = r2_score(y_test, y_pred, multioutput='raw_values')
print("Coeficiente de Determinação (R²) por classe:", r2)


# Avaliação de erro
mse = mean_squared_error(y_test, y_pred, multioutput='raw_values')  # Avaliação individual por classe
print("Erro médio quadrático por classe:", mse)


print(df2.loc[400, "intensidades"]) # teste



print("MLP")


# Lista de funções de ativação a serem testadas
activation_functions = ["relu", "identity"]

# Dicionário para armazenar os resultados e previsões
results = {}
predictions = {}

for activation in activation_functions:
    print(f"\nTreinando MLPRegressor com ativação: {activation}")

    mlp = MLPRegressor(hidden_layer_sizes=(50, 50),  
                       activation=activation,  
                       solver='adam',  
                       max_iter=50,  
                       random_state=42,
                       verbose=False,  
                       alpha=0.001)  

    mlp.fit(X_train, y_train)
    y_pred = mlp.predict(X_test)

    # Avaliação do modelo
    mae = mean_absolute_error(y_test, y_pred, multioutput='raw_values')
    mse = mean_squared_error(y_test, y_pred, multioutput='raw_values')
    r2 = r2_score(y_test, y_pred, multioutput='raw_values')

    # Armazena os resultados e previsões
    results[activation] = {"MAE": mae, "MSE": mse, "R²": r2}
    predictions[activation] = y_pred

    print(f"Erro Médio Absoluto (MAE) por classe: {mae}")
    print(f"Erro Médio Quadrático (MSE) por classe: {mse}")
    print(f"Coeficiente de Determinação (R²) por classe: {r2}")

# Convertendo os resultados para DataFrame
df_results = pd.DataFrame(results).T
df_results["R²"] = df_results["R²"].apply(lambda x: float(x[0]))  # Só o primeiro valor por simplicidade

# Gráfico de barras do R²
plt.figure(figsize=(10, 5))
df_results["R²"].plot(kind="bar", alpha=0.7)
plt.xlabel("Função de Ativação")
plt.ylabel("Coeficiente de Determinação (R²)")
plt.title("Comparação do R² entre diferentes funções de ativação no MLPRegressor")
plt.xticks(rotation=0)
plt.grid(axis="y", linestyle="--", alpha=0.7)
plt.show()


# Comparação dos valores reais e preditos para cada ativação
n = 60
for activation in activation_functions:
    print(f"\nComparação dos valores reais e preditos para ativação: {activation}\n")
    df_comparacao = pd.DataFrame(y_test, columns=classes)
    for i, c in enumerate(classes):
        df_comparacao[f'Predito_{c}'] = predictions[activation][:, i]
    print(df_comparacao.head(n))