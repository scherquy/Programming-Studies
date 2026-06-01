'''
Crie uma variável chamada “frase” e atribua a ela uma string de sua escolha. Em seguida, imprima a frase sem espaços em branco no início e no fim.
'''

frase = str(input("\nEscreva uma frase: \n\n"))

frase = frase.strip()

print(f"\n{frase}\n")