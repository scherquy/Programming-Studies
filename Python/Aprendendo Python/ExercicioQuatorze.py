'''
Crie um programa que solicite dois valores numéricos, um numerador e um denominador, e realize a divisão entre os dois valores.
Deixe claro que o valor do denominador não pode ser 0.
'''

numerador = int(input("\nInforme o numerador: "))
denominador = int(input("Informe o denominador: "))

div = numerador/denominador

print(f"\n{numerador} / {denominador} = {div:.2f}\n")