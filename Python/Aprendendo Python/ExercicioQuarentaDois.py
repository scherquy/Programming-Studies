'''
Escreva um programa que peça dois números inteiros e imprima todos os números inteiros entre eles.
'''

val1 = int(input("\nInforme um valor: "))
val2 = int(input("Informe um valor: "))
print()

for x in range(val1+1, val2, 1):
    print(x)

print()