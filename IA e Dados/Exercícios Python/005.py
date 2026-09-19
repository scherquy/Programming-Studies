'''
Leia nome e idade e informe quantos anos a pessoa terá daqui a 5, 10 e 20 anos.
Critério de conclusão: Evite repetir cálculos manualmente no texto.
Desafio extra: Peça o ano atual e estime o ano de nascimento.
'''

nome = str(input("\nInforme o seu nome: "))
idade = int(input("Informe a sua idade: "))
anoAtual = int(input("Informe o ano atual: "))

anoNascimento = anoAtual - idade

print(f"\n{nome} nasceu em {anoNascimento}")
print(f"Daqui a 5 anos {nome} vai ter {idade + 5}")
print(f"Daqui a 10 anos {nome} vai ter {idade + 10}")
print(f"Daqui a 20 anos {nome} vai ter {idade + 20}\n")