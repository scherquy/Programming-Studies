'''
Um instituto de meteorologia deseja fazer um estudo de temperatura média de cada mês do ano.
Para isso, você precisa fazer um código que colete e armazene essas temperaturas médias em uma lista.
Depois, calcule a média anual das temperaturas e mostre todas as temperaturas acima da média anual
e em que mês elas ocorreram, mostrando os meses por extenso (Janeiro, Fevereiro, etc.).
'''

tempMedia = []
meses = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"]

for x in range(0, 12):
    tempMedia.append(float(input(f"\nInforme a temperatura média de {meses[x]}: ")))

media = sum(tempMedia) / len(meses)

print(f"\nTemperatua média anual: {media:.2f}\n")
print(f"Meses com a temperatura acima da média anual: ", end = "")
for y in range(0, 12):
    if tempMedia[y] > media:
        print(f"{meses[y]}", end = ", ")

print("\n\n")