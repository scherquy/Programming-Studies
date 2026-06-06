'''
Faça um programa para uma loja que vende grama para jardins. Essa loja trabalha com jardins
circulares e o preço do metro quadrado da grama é de R$ 25,00. Peça à pessoa usuária o raio
da área circular e devolva o valor em reais do quanto precisará pagar.

Dica: use a variável pi e o método pow() da biblioteca math.
O cálculo da área de um círculo é de: A = π*r^2
'''

import math

raio = float(input("\nInforme o raio da área circular: "))

area = math.pi * pow(raio, 2)

valorPagar = area * 25

print(f"\nTamanho da área: {area:.2f}m²")
print(f"\nTotal a pagar: R${valorPagar:.2f}\n")