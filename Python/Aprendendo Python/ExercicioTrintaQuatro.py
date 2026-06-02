'''
Escreva um programa que leia três números e os exiba em ordem decrescente
'''

val1 = int(input("\nInforme um número inteiro: "))
val2 = int(input("Informe um número inteiro: "))
val3 = int(input("Informe um número inteiro: "))
aux = 0

if val2 > val1:
    aux = val2
    val2 = val1
    val1 = aux

if val3 > val1:
    aux = val3
    val3 = val1
    val1 = aux

if val3 > val2:
    aux = val3
    val3 = val2
    val2 = aux

print(f"\n{val1}, {val2}, {val3}\n")