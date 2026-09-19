'''
Peça nome, idade, cidade e área de interesse. Exiba uma apresentação em uma única frase bem formatada.
Critério de conclusão: O programa deve funcionar com valores diferentes sem alterar o código.
Desafio extra: Mostre também a idade aproximada em meses.
'''

name = str(input("\nEnter your name: "))
age = int(input("Enter your age: "))
city = str(input("Enter your city: "))
interestArea = str(input("Enter your area of interest: "))
ageMonth = int(age * 12)

print(f"\nMy name is {name}, i have {age} years old and i'm from {city}. My area of interest it's {interestArea}.\n")
print(f"Age in month: {ageMonth} months\n")