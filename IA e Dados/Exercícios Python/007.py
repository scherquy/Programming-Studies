'''
Leia o preço de um produto e uma porcentagem de desconto. Mostre valor do desconto e preço final.

Inclua uma taxa adicional de frete depois do desconto.
'''

preco = float(input("\nInforme o preço do produto: "))

desconto = float(input("\nInforme a porcentagem de desconto: "))

taxa_frete = 12

valor_final = preco - ((desconto/100) * preco) + taxa_frete

print(f"\nValor do desconto: {(desconto/100) * preco:.2f}\nValor total a pagar: R$ {valor_final:.2f}\n")