'''
Vamos entender a distribuição de idades de pensionistas de uma empresa de previdência.
Escreva um programa que leia as idades de uma quantidade não informada de clientes e
mostre a distribuição em intervalos de [0-25], [26-50], [51-75] e [76-100].
Encerre a entrada de dados com um número negativo.
'''

idade = 0
cont0_25 = 0
cont26_50 = 0
cont51_75 = 0
cont76_100 = 0

while idade >= 0:
    idade = int(input("\nInforme a sua idade: "))

    if idade >= 0 and idade <=25:
        cont0_25 += 1
    elif idade >= 26 and idade <= 50:
        cont26_50 += 1
    elif idade >= 51 and idade <= 75:
        cont51_75 += 1
    elif idade >= 76 and idade <= 100:
        cont76_100 += 1

print(f"\nQuantidade de pessoas com idade entre 0 e 25 anos: {cont0_25}")
print(f"\nQuantidade de pessoas com idade entre 26 e 50 anos: {cont26_50}")
print(f"\nQuantidade de pessoas com idade entre 51 e 75 anos: {cont51_75}")
print(f"\nQuantidade de pessoas com idade entre 76 e 100 anos: {cont76_100}\n")
