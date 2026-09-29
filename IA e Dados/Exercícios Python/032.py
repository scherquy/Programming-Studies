'''
Leia um número inteiro e informe se é par ou ímpar.
Critério de conclusão: Use o operador de resto.
Desafio extra: Classifique também como múltiplo de 5 ou não.
'''

numero = int(input("\nInforme um número inteiro: "))

if (numero % 2) == 0:
    print(f"\n{numero} é PAR.\n")
    if (numero % 5) == 0:
        print(f"{numero} é múltiplo de 5.\n")
else:
    print(f"\n{numero} é ÍMPAR.\n")
    if (numero % 5) == 0:
        print(f"{numero} é múltiplo de 5.\n")