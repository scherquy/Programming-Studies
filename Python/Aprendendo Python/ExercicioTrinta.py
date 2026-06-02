'''
Escreva um programa que solicite o percentual de crescimento de produção de uma empresa
e informe se houve um crescimento (porcentagem positiva) ou decrescimento (porcentagem negativa)
'''

porcentagem = float(input("\nInforme a percentual de crescimento de produção da empresa: "))

if porcentagem > 0:
    print(f"\nO percentual foi de {porcentagem}%. Houve crescimento\n")
elif porcentagem == 0:
    print(f"\nO percentual foi de {porcentagem}%. Não houve crescimento e nem decrescimento\n")
else:
    print(f"\nO percentual foi de {porcentagem}%. Houve decrescimento\n")