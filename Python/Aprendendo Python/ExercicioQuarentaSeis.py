'''
Escreva um programa que calcule o fatorial de um número inteiro fornecido pela pessoa usuária.
Lembrando que o fatorial de um número inteiro é a multiplicação desse número por todos os seus
antecessores até o número 1. Por exemplo, o fatorial de 5 é 5 x 4 x 3 x 2 x 1 = 120.
'''

num = int(input("\nInforme um número inteiro: "))
fat = 1;

for x in range(num, 0, -1):
    if num <= 0:
        fat = 1
    else:
        fat *= x

print(f"\n{num}! = {fat}\n")