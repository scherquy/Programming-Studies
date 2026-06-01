'''
Crie um código que solicite uma frase à pessoa usuária e imprima a mesma frase com todas as vogais “e” trocadas pela letra “f”.
'''

frase = str(input("\nEscreva uma frase: \n\n"))

frase = frase.replace("e", "f")

print(f"\n{frase}\n")