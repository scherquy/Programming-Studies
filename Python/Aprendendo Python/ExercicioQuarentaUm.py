'''
Em uma empresa de venda de imóveis você precisa criar um código que analise os dados de vendas anuais
para ajudar a diretoria na tomada de decisão. O código precisa coletar os dados de quantidade de venda
durante os anos de 2022 e 2023 e fazer um cálculo de variação percentual.
A partir do valor da variação, deve ser enviada às seguintes sugestões:

    Para variação acima de 20%: bonificação para o time de vendas.
    Para variação entre 2% e 20%: pequena bonificação para time de vendas.
    Para variação entre 2% e -10%: planejamento de políticas de incentivo às vendas.
    Para variação abaixo de -10%: corte de gastos.
'''

vendas1 = int(input("\nQuantidade de vendas 2022: "))
vendas2 = int(input("Quantidade de vendas 2023: "))

variacao = ((vendas2 - vendas1) / vendas1) * (100)
print(f"\nA variação foi de {variacao:.2f}%")

if variacao > 20:
    print(f"\nBonificação para o time de vendas\n")
elif variacao >= 2 and variacao <= 20:
    print("\nPequena bonificação para o time de vendas\n")
elif variacao < 2 and variacao >= -10:
    print("\nPlanejamento de políticas de incentivo às vendas\n")
else:
    print("\nCorte de gastos\n")