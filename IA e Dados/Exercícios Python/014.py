'''
Leia uma meta mensal e o valor já vendido. Informe quanto falta e o percentual da meta atingido.

Critério de conclusão: Funcione também quando a meta já tiver sido ultrapassada.

Desafio extra: Informe quanto foi ultrapassado quando aplicável.
'''

meta_mensal = float(input("\nInforme a meta mensal: R$ "))
valor_vendido = float(input("Informe o valor vendido até o momento: R$ "))
porcentagem = (100 * valor_vendido) / meta_mensal

if (meta_mensal - valor_vendido) > 0:
    valor_faltante = meta_mensal - valor_vendido

    print(f"\nVocê atingiu {porcentagem:.2f}% da meta. Venda mais R$ {valor_faltante:.2f} para bater a meta.\n")

elif (meta_mensal - valor_vendido) == 0:
    print(f"\nVocê bateu a meta. Meus parabéns.\n")

else:
    valor_extra = valor_vendido - meta_mensal
    print(f"\nVocê ultrapassou a meta mensal em R$ {valor_extra:.2f} ({porcentagem:.2f}%). Passe no RH para retirar o seu bônus.\n")