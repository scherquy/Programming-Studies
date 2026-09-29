'''
Leia valor do pedido. Defina frete grátis acima de determinado valor; abaixo disso, cobre uma taxa.
Critério de conclusão: Mostre subtotal, frete e total.
Desafio extra: Crie uma faixa intermediária com frete reduzido.
'''

valor_pedido = float(input("\nInforme o valor do pedido: "))
valor_frete = float(15)
valor_total = float(0)

if valor_pedido <= 10:
    valor_total = valor_pedido + valor_frete

elif (valor_pedido < 20) and (valor_pedido > 10):
    valor_frete = 7.5
    valor_total = valor_pedido + valor_frete

else:
    valor_frete = 0
    valor_total = valor_pedido

print(f"\nSubtotal: R$ {valor_pedido}")
print(f"Frete: R$ {valor_frete}")
print(f"Valor total do pedido: R$ {valor_total}\n")