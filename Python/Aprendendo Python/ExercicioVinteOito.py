'''
Crie um código que solicite uma frase à pessoa usuária e imprima a mesma frase com todas as consoantes “s” trocadas pelo caractere “$”.
'''

frase = str(input("\nEscreva uma frase: \n\n"))

frase = frase.lower().replace("s", "$")

print(f"\n{frase}\n")