'''
Defina faixas de comissão conforme vendas: até 5 mil, até 10 mil, até 20 mil e acima. Leia vendas e calcule comissão.
Critério de conclusão: O percentual deve mudar conforme a faixa.
Desafio extra: Adicione bônus quando a meta for superada.
'''

vendas = float(input("\nInforme quanto o funcionário vendeu esse mês: R$ "))
comissao = float(0)
bonus = float(0)

if (vendas <= 5000):
    comissao = (2 / 100) * vendas

elif (vendas > 5000) and (vendas <= 10000):
    bonus = 200
    comissao = ((5 / 100) * vendas) + bonus

elif (vendas > 10000) and (vendas <= 20000):
    bonus = 500
    comissao = ((8 / 100) * vendas) + bonus

else:
    bonus = 1000
    comissao = ((10 / 100) * vendas) + bonus

if(vendas <= 5000):
    print(f"\nO funcionário vendeu R$ {vendas:.2f} no mês.")
    print(f"\nSua comissão é de R$ {comissao:.2f}.\n")

else:
    print(f"\nO funcionário vendeu R$ {vendas:.2f} no mês.")
    print(f"\nRecebeu um bônus de R$ {bonus:.2f}.")
    print(f"\nSua comissão é de R$ {comissao:.2f}.\n")