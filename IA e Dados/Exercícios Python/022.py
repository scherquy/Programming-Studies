'''
Leia nome completo e exiba as iniciais em maiúsculas.

Critério de conclusão: Funcione para nomes com 2 ou mais palavras.

Desafio extra: Monte também uma sugestão de usuário como nome.sobrenome.
'''

nome_completo = str(input("\nInforme o seu nome completo: "))

nome_formatado = nome_completo.strip().title()

lista_nome = nome_formatado.split()

sugestao_nome = f"{lista_nome[0]}.{lista_nome[-1]}"

print(f"\nNome completo: {nome_formatado}\nSugestão de usuário: {sugestao_nome}\n")