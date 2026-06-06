'''
O setor de RH da sua empresa te pediu uma ajuda para analisar as idades de colaboradores(as)
de 4 setores da empresa. Para isso, foram fornecidos os seguintes dados:

{'Setor A': [22, 26, 30, 30, 35, 38, 40, 56, 57, 65],
 'Setor B': [22, 24, 26, 33, 41, 49, 50, 54, 60, 64],
 'Setor C': [23, 26, 26, 29, 34, 35, 36, 41, 52, 56],
 'Setor D': [19, 20, 25, 27, 34, 39, 42, 44, 50, 65]}

Sabendo que cada setor tem 10 colaboradores(as), construa um código que calcule a média de
idade de cada setor, a idade média geral entre todos os setores e quantas pessoas estão
acima da idade média geral.
'''

setores = {
    'Setor A': [22, 26, 30, 30, 35, 38, 40, 56, 57, 65],
    'Setor B': [22, 24, 26, 33, 41, 49, 50, 54, 60, 64],
    'Setor C': [23, 26, 26, 29, 34, 35, 36, 41, 52, 56],
    'Setor D': [19, 20, 25, 27, 34, 39, 42, 44, 50, 65]
}

mediaIdadeGeral = 0
acimaMediaGeral = 0
somaSetores = 0

print()
for setor, idades in setores.items():
    mediaIdade = sum(idades) / len(idades)
    somaSetores += sum(idades)

    print(f"Média de idade do {setor}: {mediaIdade} anos")

mediaIdadeGeral = somaSetores / (len(setores) * len(idades))

for setor, idades in setores.items():
    for idade in idades:
        if idade > mediaIdadeGeral:
            acimaMediaGeral += 1

print(f"\nIdade média geral: {mediaIdadeGeral} anos")
print(f"Pessoas com a idade acima da idade média geral: {acimaMediaGeral}\n")