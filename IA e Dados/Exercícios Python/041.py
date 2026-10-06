'''
Imprima os números de 1 a 100. Depois altere para imprimir apenas os pares.
Critério de conclusão: Use range de forma adequada.
Desafio extra: Faça também em ordem decrescente.
'''

print("\nCRESCENTE:")
for x in range(1, 101, 1):
    print(x)

print("\nCRESCENTE PARES:")
for x in range(1, 101, 1):
    if (x % 2) == 0:
        print(x)

print("\nDECRESCENTE:")
for x in range(100, 0, -1):
    print(x)

print("\nDECRESCENTE PARES:")
for x in range(100, 0, -1):
    if (x % 2) == 0:
        print(x)