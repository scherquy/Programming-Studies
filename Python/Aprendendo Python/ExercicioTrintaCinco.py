'''
Escreva um programa que pergunte em qual turno a pessoa usuária estuda ("manhã", "tarde" ou "noite")
e exiba a mensagem "Bom Dia!", "Boa Tarde!", "Boa Noite!", ou "Valor Inválido!", conforme o caso
'''

turno = str(input("\nVocê estuda de manhã, tarde ou noite? "))

turno = turno.lower().replace("ã", "a")

if turno == "manha":
    print(f"\nBom Dia!\n")
elif turno == "tarde":
    print(f"\nBoa Tarde!\n")
elif turno == "noite":
    print(f"\nBoa Noite!\n")
else:
    print(f"\nValor Inválido\n")