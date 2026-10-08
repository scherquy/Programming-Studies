'''
Peça 7 valores de vendas diárias e conte quantos dias ficaram acima de uma meta fixa.
Critério de conclusão: Mostre quantidade e percentual de dias.
Desafio extra: Guarde os valores em lista para reutilizar depois.
'''

meta = float(50)
diasAcimaDaMeta = int(0)
percentual = float(0)
vendas = []

for x in range(0, 7, 1):
    venda = float(input(f"\nInforme o valor vendido no {x+1}º dia: "))

    vendas.append(venda)

    if (venda > meta):
        diasAcimaDaMeta += 1

percentual = float((100 * diasAcimaDaMeta) / 7)

print(f"\nA meta fixa de vendas diárias é de R$ {meta:.2f}")
print(f"Vendas em cada dia da semana: {[f"{x:.2f}" for x in vendas]}")
print(f"Quantidade de dias que tiveram vendas acima da meta: {diasAcimaDaMeta}")
print(f"Percentual de dias acima da meta: {percentual:.2f}%\n")