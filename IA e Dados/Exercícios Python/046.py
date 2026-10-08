'''
Crie um menu com opções 1) somar, 2) subtrair, 0) sair. O programa deve continuar até 0.
Critério de conclusão: Opção inválida não pode encerrar o programa.
Desafio extra: Inclua multiplicação e divisão.
'''
op = int(1)

while True:
    print(f"{" ":_<26}")
    print(f"|{"":<25}|")
    print(f"|{"CALCULADORA":^25}|")
    print(f"|{"":<25}|")
    print(f"|{" 1. Somar":<25}|")
    print(f"|{" 2. Subtrair":<25}|")
    print(f"|{" 3. Multiplicar":<25}|")
    print(f"|{" 4. Dividir":<25}|")
    print(f"|{" 0. Desligar calculadora":<25}|")
    print(f"|{"":_^25}|")

    op = int(input("\nInforme a opção: "))

    if (op == 0):
        print("\nVocê desligou a calculadora.\n")
        break

    elif (op > 4) or (op < 0):
        print("\nOpção inválida")
        continue

    valor1 = float(input("\nInforme o 1º valor: "))
    valor2 = float(input("Informe o 2º valor: "))

    match op:
        case 1:
            soma = valor1 + valor2
            print(f"\n{valor1:.2f} + {valor2:.2f} = {soma:.2f}\n")

        case 2:
            sub = valor1 - valor2
            print(f"\n{valor1:.2f} - {valor2:.2f} = {sub:.2f}\n")

        case 3:
            mult = valor1 * valor2
            print(f"\n{valor1:.2f} x {valor2:.2f} = {mult:.2f}\n")

        case 4:
            div = valor1 / valor2
            print(f"\n{valor1:.2f} / {valor2:.2f} = {div:.2f}\n")