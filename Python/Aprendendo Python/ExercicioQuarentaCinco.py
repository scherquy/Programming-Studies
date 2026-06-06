'''
Desenvolva um programa que leia um conjunto indeterminado de temperaturas
em Celsius e informe a média delas. A leitura deve ser encerrada ao ser enviado o valor -273°C.
'''

temperatura = 0
cont = 0
somaTemperaturas = 0

while temperatura != -273:
    temperatura = float(input("\nInforme a temperatura (em Celsius): "))

    if temperatura != -273:
        somaTemperaturas += temperatura
        cont += 1

mediaTemperaturas = somaTemperaturas / cont

print(f"\nMédia das temperatuas informadas: {mediaTemperaturas:.2f}\n")