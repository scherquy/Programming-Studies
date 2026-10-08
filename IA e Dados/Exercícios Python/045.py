'''
Defina uma senha no programa e peça tentativas até o usuário acertar.
Critério de conclusão: O loop deve terminar corretamente.
Desafio extra: Limite a 3 tentativas.
'''

senha = str(input("\nDefina a sua senha: "))

senha_comp = str("")
tentativa = int(3)

while (senha_comp != senha):
    if (tentativa < 0):
            print(f"\nBloqueado. Você não tem mais tentativas.\n")
            break

    senha_comp = str(input("\nInforme a sua senha para acessar o sistema: "))


    if (senha_comp != senha):
        tentativa -= 1

        if (tentativa == 0):
            print("\nEssa é a sua última tentativa.")
            continue

        elif (tentativa < 0):
            continue

        print(f"\nSenha errada. Você tem mais {tentativa} tentativa(s).")

    elif (senha_comp == senha):
        print(f"\nSenha correta. Acesso permitido.\n")