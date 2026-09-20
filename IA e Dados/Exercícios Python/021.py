'''
Leia um nome com espaços extras e letras misturadas. Remova espaços das pontas e mostre em formato de título.

Critério de conclusão: Teste com entradas como " joÃO da silVA ".

Desafio extra: Mostre quantidade total de caracteres sem contar os espaços.
'''

nome = str(input("\nInforme um nome: "))

nome_formatado = nome.strip().title()

quantidade_de_caracteres = int(len(nome_formatado.replace(" ", "")))

print(f"\nNome sem formatação: {nome}\nNome formatado: {nome_formatado}\nQuantidade de caracteres de {nome_formatado}: {quantidade_de_caracteres}\n")