'''
Leia uma temperatura em Celsius e converta para Fahrenheit.
Critério de conclusão: Exiba o resultado com uma casa decimal.
Desafio extra: Faça também Fahrenheit para Celsius em seguida.
'''

tempCelsius = float(input("\nInforme a temperatura em graus Celsius: "))

Fahrenheit = float((tempCelsius * 1.8) + 32)

print(f"\n{tempCelsius:.1f}º Celsius = {Fahrenheit:.1f}º Fahrenheit\n")

tempFahrenheit = float(input("Informe a temperatura em Fahrenheit: "))

Celsius = float((tempFahrenheit - 32) / 1.8)

print(f"\n{tempFahrenheit:.1f}º Fahrenheit = {Celsius:.1f}º Celsius\n")