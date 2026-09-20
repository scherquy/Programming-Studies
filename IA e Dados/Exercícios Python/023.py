'''
Leia um e-mail e verifique apenas se contém @ e ponto. Não precisa ser uma validação real de internet.

Critério de conclusão: Produza True/False e uma mensagem legível.

Desafio extra: Converta para minúsculas antes de analisar.
'''

email = str(input("\nInforme o seu email: "))
cont_arroba = 0
cont_ponto = 0

email_formatado = email.strip().replace(" ", "").lower()

for x in range(0, len(email_formatado), 1):
    if email_formatado[x] == "@":
        cont_arroba = 1

    if email_formatado[x] == ".":
        cont_ponto = 1

if cont_arroba == 1 and cont_ponto == 1:
    print(f"\nTRUE. Seu email possui . e @\n")
else:
    print(f"\nFALSE. Seu email é inválido não possui . e @\n")