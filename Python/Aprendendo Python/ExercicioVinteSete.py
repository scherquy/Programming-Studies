'''
Crie um código que solicite uma frase à pessoa usuária e imprima a mesma frase com todas as vogais “a” trocadas pela caractere “@”.
'''

frase = str(input("\nEscreva uma frase: \n\n"))

frase = frase.lower().replace("a", "@")

print(f"\n{frase}\n")