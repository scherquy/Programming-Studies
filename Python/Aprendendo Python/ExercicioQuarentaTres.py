'''
Escreva um programa para calcular quantos dias levará para a colônia
de uma bactéria A ultrapassar ou igualar a colônia de uma bactéria B,
com base nas taxas de crescimento de 3% e 1,5% respectivamente.
Considere que a colônia A inicia com 4 elementos e a B com 10.
'''

A = 4
B = 10

days = 0

while A <= B:
    A += ((3/100)*A)
    B += ((1.5/100)*B)
    days += 1
    print(f"\nElementos de A: {A}")
    print(f"Elementos de B: {B}")
    print(f"Dias: {days}\n")