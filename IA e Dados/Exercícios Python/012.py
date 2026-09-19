'''
Leia total vendido e percentual de comissão e calcule a comissão do vendedor.

Mostre vendas, taxa e valor final.

Desafio extra: Some um bônus fixo informado pelo usuário.
'''

total_vendas = float(input("\nInforme o total vendido em R$: "))
percent_comissao = float(input("Informe o percentual de comissão: "))
bonus = float(input("Informe o bônus fixo em R$:  "))

valor_final = ((percent_comissao / 100) * total_vendas) + bonus

print(f"\nTotal de vendas: R$ {total_vendas}\nTaxa: {percent_comissao}%\nValor final: R$ {valor_final}\n")