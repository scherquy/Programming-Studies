'''
Leia um valor em reais e uma cotação informada pelo usuário. Converta para a moeda desejada.

Critério de conclusão: Não use internet nem biblioteca externa.
'''

real = float(input("\nInforme o valor que deseja converter: R$ "))
conversao = float(0)

print(" _______________________________________")
print("\n| <<< MENU DE MOEDAS PARA CONVERSÃO >>> |")
print("| 1 - Dólar Americano                   |")
print("| 2 - Euro                              |")
print("| 3 - Iene Japonês                      |")
print("| 4 - Peso Argentino                    |")
print("| 5 - Peso Uruguaio                     |")
print("|_______________________________________|")

op = int(input("\nInforme para qual moeda você deseja converter: "))

match op:
    case 1: 
        conversao = real * 0.19
        print(f"\nVocê tem $ {conversao:.2f}\n")
    case 2:
        conversao = real * 0.17
        print(f"\nVocê tem € {conversao:.2f}\n")
    case 3:
        conversao = real * 30.51
        print(f"\nVocê tem ¥ {conversao:.2f}\n")
    case 4:
        conversao = real * 294.23
        print(f"\nVocê tem $ {conversao:.2f}\n")
    case 5:
        conversao = real * 7.81
        print(f"\nVocê tem $U {conversao:.2f}\n")