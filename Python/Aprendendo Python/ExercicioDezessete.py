'''
Crie um programa que solicite dois valores numéricos, um numerador e um denominador,
e retorne o resto da divisão entre os dois valores. Deixe claro que o valor do denominador não pode ser 0.
'''

numerador = int(input("\nInforme o numerador: "))
denominador = int(input("Informe o denominador: "))

resto = numerador % denominador

print(f"\n{numerador} % {denominador} = {resto}\n")