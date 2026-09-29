'''
Leia idade e uma resposta S/N indicando autorização. Crie expressões booleanas que representem se o acesso seria permitido sob
diferentes regras.
'''

idade = int(input("\nInforme a sua idade: "))

permissao = str(input("Tem permissão (S ou N): "))

if idade >= 18 and permissao.upper() == "S":
    print("\nEntrada liberada\n")
elif (idade >= 18 or idade < 18) and permissao.upper() == "N":
    print("\nEntrada negada\n")
elif idade < 18 and permissao.upper() == "S":
    print("\nApresente um documento antes de entrar\n") 