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
# from xgboost import XGBClassifier
from sklearn.naive_bayes import GaussianNB
from sklearn.neural_network import MLPClassifier
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix



# ---- Definição de variáveis ----
path_to_folder = "C:/Users/labor/OneDrive/pyspectrumML/data_temp"
# Dados em formato de dicionário
dic = dataF(path_to_folder)

# Definição das classes
classes = ["Ascolana",
        "Coratina",
        "Frantoio",
        "Picual",
        "Galega",
        "koroneiki"]
# Formatação dos dados tirados do dicionário
X, y = prepare_data(dic)


# ---- REDUÇÃO DE DIMENSIONALIDADE POR PCA ----

pca = PCA(n_components = 2)
x = pca.fit_transform(X)

# ---- SPLIT DOS DADOS PARA ML ----
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)


# ---- MODELOS ----

# KNeigborsClassifier
model = KNeighborsClassifier(n_neighbors=5)
model.fit(X_train, y_train)
y_pred = model.predict(X_test)

# Ramdom Florest Classifier
model2 = RandomForestClassifier(n_estimators=6)
model2.fit(X_train, y_train)
y_pred2 = model2.predict(X_test)

# MLP Classifier

model3 = MLPClassifier(random_state=1, max_iter=400)
model3.fit(X_train, y_train)
y_pred3 = model3.predict(X_test)

# Naive Bayes

model4 = GaussianNB()
model4.fit(X_train, y_train)
y_pred4 = model4.predict(X_test)

# SVC
model5 = SVC()
model5.fit(X_train, y_train)
y_pred5 = model5.predict(X_test)


# ---- VISUALIZAÇÃO DE RESULTADOS -----

# Definição da matriz de confusão
# KNeighborsClassifier
conf_matrix = confusion_matrix(y_test, y_pred)

# Random Florest Classifier
conf_matrix2 = confusion_matrix(y_test, y_pred2)

# MLP Classifier
conf_matrix3 = confusion_matrix(y_test, y_pred3)

# Naive Bayes
conf_matrix4 = confusion_matrix(y_test, y_pred4)

# SVC
conf_matrix5 = confusion_matrix(y_test, y_pred5)

# Visualização do resultado do PCA
PCA_variance_plot(pca)
PCA_plot_2D(x, y, classes)

# Visualização dos resultados do Modelo de ML
# KNeighbors Classifier
print("KNeibors Classifier")
score(y_test, y_pred)
mtx_conf_norm(model, X_test, y_pred, classes, "KNeibors Classifier")

# Random Florest Classifier
print("Random Florest Classifier")
score(y_test, y_pred2)
mtx_conf_norm(model2, X_test, y_pred, classes, "Random Florest Classifier")

# MPL Classifier
print("MPL Classifier")
score(y_test, y_pred3)
mtx_conf_norm(model3, X_test, y_pred, classes, "MPL Classifier")

# Naive Bayes
print("Naive Bayes")
score(y_test, y_pred4)
mtx_conf_norm(model4, X_test, y_pred, classes, "Naive Bayes")

# SVC 
print("SVC")
score(y_test, y_pred5)
mtx_conf_norm(model5, X_test, y_pred, classes, "SVC")
