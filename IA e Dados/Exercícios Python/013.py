'''
Leia preço de venda e custo de um produto. Calcule lucro unitário e margem percentual sobre o preço de venda.

Critério de conclusão: Mostre valores em reais e percentual.
'''

preco_venda = float(input("\nQual o preço de venda do produto: R$ "))
custo = float(input("Qual o custo do produto: R$ "))

lucro_unitario = preco_venda - custo

margem_percent = (lucro_unitario / preco_venda) * 100

print(f"\nPreço de venda: R$ {preco_venda:.2f}")
print(f"Custo: R$ {custo:.2f}")
print(f"Lucro unitário: R$ {lucro_unitario:.2f}")
print(f"Margem percentual: {margem_percent:.2f}%\n")