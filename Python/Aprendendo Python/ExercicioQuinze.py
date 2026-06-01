'''
Crie um programa que solicite dois valores numéricos, um operador e uma potência,
e realize a exponenciação entre esses dois valores.
'''

operador = int(input("\nInforme o valor do operador: "))
potencia = int(input("Informe o valor da potência: "))

pot = operador ** potencia

print(f"\n{operador} ^ {potencia} = {pot}\n")