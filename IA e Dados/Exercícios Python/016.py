'''
Leia preço e quantidade de duas embalagens do mesmo produto. Calcule o preço por unidade de cada uma.

Critério de conclusão: Mostre os dois preços unitários.

Desafio extra: Diga qual é mais barata usando condicionais quando chegar ao bloco seguinte.
'''

quantidade_embalagem_A = float(input("\nInforme a quantidade da 1º embalagem (em gramas): "))
preco_embalagem_A = float(input("Informe o preço da 1º embalagem: R$ "))
preco_unidade_A = preco_embalagem_A / quantidade_embalagem_A

quantidade_embalagem_B = float(input("\nInforme a quantidade da 2º embalagem (em gramas): "))
preco_embalagem_B = float(input("Informe o preço da 2º embalagem: R$ "))
preco_unidade_B = preco_embalagem_B / quantidade_embalagem_B

print(f"\nPreço por unidade A: R$ {preco_unidade_A:.5f}")

print(f"\nPreço por unidade B: R$ {preco_unidade_B:.5f}")

if preco_unidade_A > preco_unidade_B:
    print(f"\nB é mais barata por unidade ({preco_unidade_A:.5f} > {preco_unidade_B:.5f})\n")
elif preco_unidade_A < preco_unidade_B:
    print(f"\nA é mais barata por unidade ({preco_unidade_A:.5f} < {preco_unidade_B:.5f})\n")
else:
    print(f"\nAmbas tem o mesmo preço por unidade ({preco_unidade_A:.5f} = {preco_unidade_B:.5f})\n")