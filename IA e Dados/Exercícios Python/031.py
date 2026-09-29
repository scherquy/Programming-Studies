'''
Leia um número e classifique-o como positivo, negativo ou zero.
Critério de conclusão: Use exatamente uma cadeia if/elif/else.
Desafio extra: Informe também se é inteiro ou decimal caso você leia como float.
'''

numero = float(input("\nInforme um número qualquer: "))

if numero > 0:
    if (numero % 1) == 0:
        print(f"\n{int(numero)} é positivo e inteiro\n")
    else:
        print(f"\n{numero} é positivo e decimal\n")

elif numero < 0:
    if (numero % 1) == 0:
        print(f"\n{int(numero)} é negativo e inteiro\n")
    else:
        print(f"\n{numero} é negativo e decimal\n")

else:
    print(f"\n{int(numero)} é zero e inteiro\n")