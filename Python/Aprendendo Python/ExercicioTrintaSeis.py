'''
Escreva um programa que peça um número inteiro à pessoa usuária e determine se ele é par ou ímpar.
Dica: Você pode utilizar o operador módulo %
'''

value = int(input("\nInforme um valor: "))

if (value % 2) == 0:
    print(f"\n{value} é PAR\n")
else:
    print(f"\n{value} é ÍMPAR\n")