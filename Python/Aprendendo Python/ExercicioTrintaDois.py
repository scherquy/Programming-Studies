'''
Escreva um programa que leia valores médios de preços de um modelo de carro por 3 anos consecutivos
e exiba o valor mais alto e mais baixo entre esses três anos
'''

val1 = float(input("\nValor médio do veículo no 1º ano: R$"))
val2 = float(input("Valor médio do veículo no 2º ano: R$"))
val3 = float(input("Valor médio do veículo no 3º ano: R$"))

if val1 > val2 and val1 > val3:
    print(f"\nR${val1:.2f} foi o valor mais alto durante os 3 anos\n")
elif val2 > val1 and val2 > val3:
    print(f"\nR${val2:.2f} foi o valor mais alto durante os 3 anos\n")
else:
    print(f"\nR${val3:.2f} foi o valor mais alto durante os 3 anos\n")

if val1 < val2 and val1 < val3:
    print(f"R${val1} foi o valor mais baixo durante os 3 anos\n")
elif val2 < val1 and val2 < val3:
    print(f"R${val2} foi o valor mais baixo durante os 3 anos\n")
else:
    print(f"R${val3} foi o valor mais baixo durante os 3 anos\n")