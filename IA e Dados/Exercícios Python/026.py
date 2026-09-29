'''
Leia um código no formato CAT-2026-001 e exiba separadamente categoria, ano e número.

Critério de conclusão: Assuma inicialmente que a entrada vem correta.

Desafio extra: Depois tente detectar formato incorreto.
'''

codigo = str(input("\nInforme o código Categoria-Ano-Número (AAA-0000-000): "))

codigo_separado = codigo.strip().upper().split("-")

if (codigo_separado[0].isalpha() == True) and (codigo_separado[1].isdigit() == True) and (codigo_separado[2].isdigit() == True):
    print(f"\nCategoria: {codigo_separado[0]}")
    print(f"Ano: {codigo_separado[1]}")
    print(f"Número: {codigo_separado[2]}\n")

else:
    print(f"\nFormato Incorreto. Digite no seguinte formato:")
    print(f"\nCATEGORIA-ANO-NÚMERO -> AAA-BBBB-CCC\n")