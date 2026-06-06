'''
Faça um programa que, ao inserir um número qualquer, cria uma lista contendo todos os números primos entre 1 e o número digitado.
'''

num = int(input("\nInforme um número inteiro: "))

lista = []

for x in range(2, num):
    primo = True

    for y in range(2, x):
        if (x % y) == 0:
            primo = False
            break

    if primo == True:
        lista.append(x)

print()
print(lista)
print()