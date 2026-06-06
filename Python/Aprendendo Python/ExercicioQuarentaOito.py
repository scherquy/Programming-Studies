'''
Os números primos possuem várias aplicações dentro da Ciência de Dados em criptografia e segurança,
por exemplo. Um número primo é aquele que é divisível apenas por um e por ele mesmo.
Assim, faça um programa que peça um número inteiro e determine se ele é ou não um número primo.
'''

num = int(input("\nInforme um número inteiro: "))

primo = True

if num <= 1:
    primo = False
else:
    for x in range(2, num, 1):
        if (num % x) == 0:
            primo = False

if primo == True:
    print(f"\n{num} É PRIMO\n")
else:
    print(f"\n{num} NÃO É PRIMO\n ")