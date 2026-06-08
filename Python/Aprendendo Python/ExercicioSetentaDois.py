'''
Escreva uma função que gere a tabuada de um número inteiro de 1 a 10, de acordo com a escolha da pessoa usuária.
Como exemplo, para o número 7, a tabuada deve ser mostrada no seguinte formato:

Tabuada do 7:
7 x 0 = 0
7 x 1 = 7
[...]
7 x 10 = 70
'''

def Tabuada(valor):
    for x in range(0, 11):
        tab = valor * x
        print(f"{valor} * {x} = {tab}")


valor = int(input("\nInforme um valor inteiro para saber a tabuada: "))

print()
Tabuada(valor)
print()