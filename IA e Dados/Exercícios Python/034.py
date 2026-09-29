'''
Leia três números e mostre o maior. Tente primeiro sem usar max().
Critério de conclusão: Trate valores iguais sem erro.
Desafio extra: Mostre também o menor.
'''

maior = None
menor = None

print()
for x in range(0, 3, 1):
    valor = int(input(f"Informe o {x+1}º valor: "))

    if maior is None and menor is None:
        maior = valor
        menor = valor

    if valor >= maior:
        maior = valor

    if valor <= menor:
        menor = valor

print(f"\nMaior valor: {maior}")
print(f"Menor valor: {menor}\n")