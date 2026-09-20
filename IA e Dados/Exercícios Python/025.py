'''
Leia uma palavra e mostre-a ao contrário.

Critério de conclusão: Não altere a entrada original.

Desafio extra: Informe se a palavra é palíndroma.
'''

palavra = str(input("\nInforme uma palavra: "))

palavra_contrario = ""

for x in range(len(palavra) - 1, -1, -1):
    palavra_contrario += palavra[x]

print(f"\nPalavra: {palavra}\nPalavra ao contrário: {palavra_contrario}")

if palavra.lower() == palavra_contrario.lower():
    print(f"\nA palavra {palavra} é palíndroma\n")
else:
    print(f"\nA palavra {palavra} não é palíndroma\n")