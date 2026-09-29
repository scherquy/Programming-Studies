'''
Leia dois números e uma operação escolhida entre +, -, *, /. Execute a operação correspondente.
Critério de conclusão: Trate divisão por zero e operação inválida.
Desafio extra: Aceite também palavras como soma ou dividir.
'''

print(f"\n{" ":_<22}")
print(f"|{" ":<21}|")
print(f"|{"CALCULADORA":^21}|")
print(f"|{" ":<21}|")
print(f"|{" + -> Soma":<21}|")
print(f"|{" - -> Subtração":<21}|")
print(f"|{" * -> Multiplicação":<21}|")
print(f"|{" / -> Divisão":<21}|")
print(f"|{"":_<21}|\n\n")

op = str(input("Informe a operação que você deseja realizar: "))

op_format = op.strip().lower().replace("ç", "c").replace("ã", "a")

valor1 = float(input("\nInforme o primeiro valor: "))
valor2 = float(input("Informe o segundo valor: "))

if ((op_format == "/") or (op_format == "dividir") or (op_format == "divisao")) and (valor2 == 0):
    print(f"\nERRO!!!\n")

else:
    match op_format:
        case "+" | "somar" | "soma":
            soma = valor1 + valor2
            print(f"\n{valor1:.2f} + {valor2:.2f} = {soma:.2f}\n")

        case "-" | "subtrair" | "subtracao":
            sub = valor1 - valor2
            print(f"\n{valor1:.2f} - {valor2:.2f} = {sub:.2f}\n")

        case "*" | "multiplicar" | "multiplicacao":
            multi = valor1 * valor2
            print(f"\n{valor1:.2f} * {valor2:.2f} = {multi:.2f}\n")

        case "/" | "dividir" | "divisao":
            div = valor1 / valor2
            print(f"\n{valor1:.2f} / {valor2:.2f} = {div:.2f}\n")

        case _:
            print("\nERRO!!!\n")