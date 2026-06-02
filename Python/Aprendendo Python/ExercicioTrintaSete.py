'''
Escreva um programa que peça um número à pessoa usuária e informe se ele é inteiro ou decimal
'''

val = float(input("\nInforme um número: "))

if (val % 1) == 0:
    print(f"\n{val:.0f} é INTEIRO\n")
else:
    print(f"\n{val:.2f} é DECIMAL\n")