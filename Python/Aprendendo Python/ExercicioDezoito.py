'''
Crie um código que solicita 3 notas de um estudante e imprima a média das notas.
'''

nota1 = float(input("\nInforme a 1º nota: "))
nota2 = float(input("Informe a 2º nota: "))
nota3 = float(input("Informe a 3º nota: "))

media = float((nota1 + nota2 + nota3) / 3)

print(f"\nA média é: {media:.2f}\n")