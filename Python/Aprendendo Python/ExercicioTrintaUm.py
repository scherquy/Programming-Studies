'''
Escreva um programa que determine se uma letra fornecida pela pessoa usuária é uma vogal ou consoante
'''

letra = str(input("\nInforme uma letra: "))

if letra == "a" or letra == "A" or letra == "e" or letra == "E" or letra == "i" or  letra == "I" or letra == "o" or letra == "O" or letra == "u" or letra == "U":
    print(f"\n{letra} é VOGAL\n")
else:
    print(f"\n{letra} é CONSOANTE\n")