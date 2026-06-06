'''
Desenvolva um programa que informa a nota de um(a) aluno(a) de acordo com suas respostas.
Ele deve pedir a resposta desse(a) aluno(a) para cada questão e é preciso verificar se a
resposta foi igual ao gabarito. Cada questão vale um ponto e existem as alternativas A, B, C ou D.

Gabarito da prova:
01 - D
02 - A
03 - C
04 - B
05 - A
06 - D
07 - C
08 - C
09 - A
10 - B
'''

gabarito = ["D", "A", "C", "B", "A", "D", "C", "C", "A", "B"]
respostas = []
nota = 0

print()
for x in range(0, 10, 1):
    respostas.append(str(input(f"Informe a resposta da {x+1}º questão: ")))

for y in range(0, 10, 1):
    if respostas[y].lower() == gabarito[y].lower():
        nota += 1

print(f"\nSua nota é: {nota}")
