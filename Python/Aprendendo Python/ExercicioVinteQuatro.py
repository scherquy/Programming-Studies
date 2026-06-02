'''
Crie um código que solicite uma frase à pessoa usuária e imprima a mesma frase sem espaços em branco no início e no fim.
'''

frase = str(input("\nEscreva uma frase: \n\n"))

frase = frase.strip()

print(f"\n{frase}\n")