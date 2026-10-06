'''
Leia um ano e determine se ele é bissexto usando a regra correta de divisibilidade por 4, 100 e 400.
Critério de conclusão: Teste 1900, 2000, 2024 e 2025.
'''

ano = int(input("\nInforme o ano: "))

if (ano % 4) != 0:
    print(f"\n{ano} não é bissexto\n")

elif (ano % 4) == 0 and (ano % 100) != 0:
    print(f"\n{ano} é bissexto\n")

elif (ano % 100) == 0 and (ano % 400) != 0:
    print(f"\n{ano} não é bissexto\n")

elif (ano % 400) == 0:
    print(f"\n{ano} é bissexto\n")