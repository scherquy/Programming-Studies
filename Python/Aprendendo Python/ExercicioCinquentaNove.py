'''
Uma pesquisa de mercado foi feita para decidir qual design de marca infantil mais agrada as crianças.
A pesquisa foi feita e o votos computados podem ser observados abaixo:

Tabela de votos da marca
Design 1 - 1334 votos
Design 2 - 982 votos
Design 3 - 1751 votos
Design 4 - 210 votos
Design 5 - 1811 votos

Adapte os dados fornecidos para uma estrutura de dicionário.
A partir dele, informe o design vencedor e a porcentagem de votos recebidos.
'''

design = {
    "Design 1": 1334,
    "Design 2": 928,
    "Design 3": 1751,
    "Design 4": 210,
    "Design 5": 1811
}

maisVotado = 0
somaVotos = 0

for votos in design.keys():
    somaVotos += design[votos]

    if design[votos] > maisVotado:
        maisVotado = design[votos]
        designMaisVotado = votos

porcentagem = (maisVotado / somaVotos) * 100

print(f"\nSoma dos votos: {somaVotos}")
print(f"\n{designMaisVotado} é o mais votado com {porcentagem:.2f}% dos votos\n")