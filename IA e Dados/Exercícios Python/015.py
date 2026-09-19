'''
Leia faturamento do mês anterior e do mês atual e calcule a variação percentual.

Critério de conclusão: Explique na saída se houve crescimento ou queda apenas com o sinal do resultado por enquanto.

Desafio extra: Teste com valores iguais.
'''

mes_anterior = float(input("\nInforme o faturamento do mês anterior: R$ "))

mes_atual = float(input("Informe o faturamento do mês atual: R$ "))

variacao = ((mes_atual - mes_anterior) / mes_anterior) * 100

if variacao > 0:
    print(f"\nCrescimento de {variacao:.2f}%\n")
elif variacao < 0:
    print(f"\nQueda de {variacao:.2f}%\n")
else:
    print(f"\nNão houve queda e nem crescimento. Variação de {variacao:.2f}%\n")