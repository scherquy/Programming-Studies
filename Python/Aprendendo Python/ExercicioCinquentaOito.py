'''
Uma empresa de e-commerce está interessada em analisar as vendas dos seus produtos.
Os dados das vendas foram armazenados em um dicionário:

{
'Produto A': 300, 'Produto B': 80, 'Produto C': 60,
'Produto D': 200, 'Produto E': 250, 'Produto F': 30
}

 Escreva um código que calcule o total de vendas e o produto mais vendido.
'''

dicionario = {
    'Produto A': 300,
    'Produto B': 80,
    'Produto C': 60,
    'Produto D': 200,
    'Produto E': 250,
    'Produto F': 30
}

totalVendas = 0
maisVendido = 0
produtoMaisVendido = ""

for valor in dicionario.keys():
    totalVendas += dicionario[valor]

    if dicionario[valor] > maisVendido:
        maisVendido = dicionario[valor]
        produtoMaisVendido = valor

print(f"\nTotal de vendas: {totalVendas}")
print(f"{produtoMaisVendido} é o mais vendido\n")