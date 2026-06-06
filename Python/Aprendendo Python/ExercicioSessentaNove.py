'''
Você recebeu um desafio de calcular a raiz quadrada de uma lista de números,
identificando quais resultaram em um número inteiro. A lista é a seguinte:

numeros = [2, 8, 15, 23, 91, 112, 256]

No final, informe quais números possuem raízes inteiras e seus respectivos valores.

Dica: use a comparação entre a divisão inteira (//) da raiz por 1 com o valor
da raiz para verificar se o número é inteiro.
'''

import math

numeros = [2, 8, 15, 23, 91, 112, 256]

print()
for numero in numeros:
    raiz = (math.sqrt(numero))

    if (raiz // 1) == raiz:
        print(f"Raiz quadrada de {numero} é {raiz:.0f}. É um valor inteiro")

print()