'''
Para tratar uma quantidade de 15 dados de avaliações de pessoas usuárias de um serviço da empresa,
precisamos verificar se as notas são válidas. Então, escreva um programa que vai receber a nota
de 0 a 5 de todos os dados e verificar se é um valor válido. Caso seja inserido uma nota acima
de 5 ou abaixo de 0, repita até que a pessoa usuária insira um valor válido.
'''

nota = -999

for x in range(0, 15, 1):
    nota = int(input(f"\n{x+1}º - Informe a nota para avaliação (de 0 a 5): "))
    while nota < 0 or nota > 5:
        if nota < 0 or nota > 5:
            print("\nNota Inválida")
            
        nota = int(input(f"\n{x+1}º - Informe a nota para avaliação (de 0 a 5): "))