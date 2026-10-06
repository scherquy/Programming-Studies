'''
Leia N e calcule a soma de todos os inteiros de 1 até N usando loop.
Critério de conclusão: Não use sum() nesta versão.
Desafio extra: Compare depois com uma solução usando sum e range.
'''

numero = int(input("\nInforme um número: "))
soma = int(0)

for x in range(1, numero+1, 1):
    soma += x

print(f"\nSoma de todos os valores de 1 até {numero}: {soma}\n")

soma2 = sum(range(1, numero+1, 1), 0)

print(f"\nSoma de todos os valores de 1 até {numero}: {soma2}\n")