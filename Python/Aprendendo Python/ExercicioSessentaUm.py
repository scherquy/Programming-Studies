'''
Uma equipe de cientistas de dados está estudando a diversidade biológica em uma floresta.
A equipe fez a coleta de informações sobre o número de espécies de plantas e animais em cada
área dessa floresta e armazenou essas informações em um dicionário. Nele, a chave descreve a
área dos dados e os valores nas listas correspondem às espécies de plantas e animais nas áreas,
respectivamente.

{'Área Norte': [2819, 7236],
 'Área Leste': [1440, 9492],
 'Área Sul': [5969, 7496],
 'Área Oeste': [14446, 49688],
 'Área Centro': [22558, 45148]}

 Escreva um código para calcular a média de espécies por área e identificar a área com a maior
 diversidade biológica.
 
 Dica: use as funções built-in sum() e len(). 
'''

areas = {
    'Área Norte': [2819, 7236],
    'Área Leste': [1440, 9492],
    'Área Sul': [5969, 7496],
    'Área Oeste': [14446, 49688],
    'Área Centro': [22558, 45148]
}

maiorDiversidade = 0
areaMaiorDiversidade = ""
maiorSoma = 0

print()
for area, especies in areas.items():
    soma = 0
    media = 0
    soma += sum(especies)
    media = soma / len(especies)

    if soma > maiorDiversidade:
        maiorDiversidade = soma
        areaMaiorDiversidade = area

    print(f"Média de espécies na {area}: {media}")

print(f"\n{areaMaiorDiversidade} tem mais diversidade biológica\n")