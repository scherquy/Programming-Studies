'''
Leia três notas e calcule a média aritmética.
Critério de conclusão: Mostre a média com duas casas decimais.
Desafio extra: Mostre também a maior e a menor usando apenas recursos básicos que você já conhece.
'''

somaNotas = float(0)
mediaNotas = float(0)
maiorNota = float(0)
menorNota = float(10)

print()
for x in range(1, 4):
    nota = float(input(f"Informe a {x}º nota: "))

    somaNotas += nota

    if nota >= maiorNota:
        maiorNota = nota

    if nota <= menorNota:
        menorNota = nota

mediaNotas = float(somaNotas / 3)

print(f"\nMédia final: {mediaNotas:.2f}")
print(f"Maior nota: {maiorNota:.2f}")
print(f"Menor nota: {menorNota:.2f}\n")