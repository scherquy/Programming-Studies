'''
Leia um telefone como "(11) 99999-8888" e remova parênteses, espaço e hífen.
Critério de conclusão: A saída deve conter apenas os dígitos fornecidos.
Desafio extra: Valide pelo comprimento resultante.
'''

telefone = str(input("\nInforme o seu número de telefone [(XX) XXXXX-XXXX]: "))

telefone_format = telefone.strip().replace("(", "").replace(")", "").replace(" ", "").replace("-", "")

print(telefone_format)

if telefone_format.isdigit() == True and len(telefone_format) == 11:
    print(f"\nSeu número de celular {telefone_format} está correto.\n")
else:
    print("\nNúmero de celular INCORRETO\n")