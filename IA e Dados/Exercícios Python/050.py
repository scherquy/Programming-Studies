'''
Leia um valor inteiro e calcule quantas notas de 100, 50, 20, 10, 5 e 2 seriam usadas em uma estratégia gulosa simples.
Critério de conclusão: Mostre quantidade por nota.
Desafio extra: Informe eventual resto que não pode ser atendido.
'''

notas = [100, 50, 20, 10, 5, 2]

valor = float(input("\nInforme o valor em R$ "))

print()
for x in notas:
    if (valor >= 2):
        notas = int(valor // x)
        valor %= x

        print(f"Notas de {x}: {notas}")

    if (valor < 2) and (valor >= 0):
        print(f"Resto não atendido: {valor:.2f}\n")
        break