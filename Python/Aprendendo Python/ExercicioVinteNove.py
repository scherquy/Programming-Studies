'''
Escreva um programa que peça à pessoa usuária para fornecer dois números e exibir o número maior.
'''

val1 = int(input("\nInforme um número inteiro: "))
val2 = int(input("Informe um número inteiro: "))

if val1 >= val2:
    print(f"\n{val1} é maior\n")
else:
    print(f"\n{val2} é maior\n")