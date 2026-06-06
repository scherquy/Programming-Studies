'''
Um programa deve ser escrito para ler dois números e, em seguida,
perguntar à pessoa usuária qual operação ele deseja realizar.
O resultado da operação deve incluir informações sobre o número
- se é par ou ímpar, positivo ou negativo e inteiro ou decimal.
'''

print("\n---------- MENU ----------")
print("|1 - SOMA                |")
print("|2 - SUBTRAÇÃO           |")
print("|3 - MULTIPLICAÇÃO       |")
print("|4 - DIVISÃO             |")
print("--------------------------")
op = int(input("\nEscolha uma opção: "))

if op != 1 and op != 2 and op != 3 and op != 4:
    print("\nVALOR INVÁLIDO\n")

else:
    val1 = int(input("\nInforme o 1º valor: "))
    val2 = int(input("Informe o 2º valor: "))

    match op:
        case 1:
            soma = val1 + val2
            print(f"\n{val1} + {val2} = {soma}\n")
        case 2:
            sub = val1 - val2
            print(f"\n{val1} - {val2} = {sub}\n")
        case 3:
            mult = val1 * val2
            print(f"\n{val1} x {val2} = {mult}\n")
        case 4:
            div = val1 / val2
            print(f"\n{val1} / {val2} = {div}\n")