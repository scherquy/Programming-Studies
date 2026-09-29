'''
Leia um título como "Meu Primeiro Projeto em Python" e transforme em "meu-primeiro-projeto-em-python".
Critério de conclusão: Evite espaços duplicados.
Desafio extra: Remova pontuação simples como !, ?, ., ,.
'''

frase = str(input("\nInforme uma frase: "))

lista = frase.strip().lower().replace("  ", " ").replace("!", " ").replace("?", " ").replace(".", " ").replace(",", " ").split()

frase_format = "-".join(lista)

print(f"\n{frase_format}\n")