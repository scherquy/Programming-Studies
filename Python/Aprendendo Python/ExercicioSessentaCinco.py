'''
Crie um programa que solicite à pessoa usuária digitar dois números inteiros
e calcular a potência do 1º número elevado ao 2º.

Dica: use a função pow() da biblioteca math
'''

import math

base = int(input("\nInforme o valor da base: "))
exp = int(input("Informe o valor do expoente: "))

res = int(math.pow(base, exp))

print(f"\n{base}^{exp} = {res}\n")