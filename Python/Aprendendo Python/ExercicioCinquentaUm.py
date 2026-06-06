'''
Faça um programa que tenha a seguinte lista contendo os valores de gastos de uma empresa
de papel [2172.54, 3701.35, 3518.09, 3456.61, 3249.38, 2840.82, 3891.45, 3075.26, 2317.64, 3219.08].
Com esses valores, faça um programa que calcule a média de gastos.

Dica: use as funções built-in sum() e len(). 
'''

vetor = [2172.54, 3701.35, 3518.09, 3456.61, 3249.38, 2840.82, 3891.45, 3075.26, 2317.64, 3219.08]

media = sum(vetor) / len(vetor)

print(f"\nMédia de gastos: R${media:.2f}\n")

