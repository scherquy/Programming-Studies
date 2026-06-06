'''
Escreva um programa que peça à pessoa usuária três números que representam os lados de um triângulo.
O programa deve informar se os valores podem ser utilizados para formar um triângulo e,
caso afirmativo, se ele é equilátero, isósceles ou escaleno. Tenha em mente algumas dicas:

    Três lados formam um triângulo quando a soma de quaisquer dois lados for maior que o terceiro;
    Triângulo Equilátero: três lados iguais;
    Triângulo Isósceles: quaisquer dois lados iguais;
    Triângulo Escaleno: três lados diferentes.
'''

ladoA = float(input("\nInforme o tamanho do lado A do triângulo: "))
ladoB = float(input("Informe o tamanho do lado B do triângulo: "))
ladoC = float(input("Informe o tamanho do lado C do triângulo: "))

if ((ladoA + ladoB) > ladoC) and ((ladoA + ladoC) > ladoB) and ((ladoB + ladoC) > ladoA):
    if ladoA == ladoB == ladoC:
        print(f"\nÉ um triângulo EQUILÁTERO\n")
    elif (ladoA == ladoB) or (ladoA == ladoC) or (ladoC == ladoB):
        print(f"\nÉ um triângulo ISÓSCELES\n")
    else:
        print(f"\nÉ um triângulo ESCALENO\n")
else:
    print(f"\nEsses valores NÃO FORMAM um triângulo\n")