'''
Em uma eleição para gerência em uma empresa com 20 pessoas colaboradoras, existem quatro candidatos(as).
Escreva um programa que calcule o(a) vencedor(a) da eleição. A votação ocorreu da seguinte maneira:

    Cada colaborador(a) votou em uma das quatro pessoas candidatas (que representamos pelos números 1, 2, 3 e 4).
    Também foram contabilizados os votos nulos (representados pelo número 5) e os votos em branco (representados pelo número 6).

Ao final da votação, o programa deve exibir o número total de votos para cada candidato(a), os nulos e os votos em branco.
Além disso, deve calcular e exibir a porcentagem de votos nulos em relação ao total de votos e a porcentagem de votos
em branco em relação ao total de votos.
'''

cont1 = 0
cont2 = 0
cont3 = 0
cont4 = 0
nulo = 0
branco = 0

for x in range (1, 21, 1):
    print(f"\n _________URNA PARA OS VOTOS_________")
    print(f"|                                    |")
    print(f"| 1 - Candidato(a) UM (digite 1)     |")
    print(f"| 2 - Candidato(a) DOIS (digite 2)   |")
    print(f"| 3 - Candidato(a) TRÊS (digite 3)   |")
    print(f"| 4 - Candidato(a) QUATRO (digite 4) |")
    print(f"| 5 - Voto NULO (digite 5)           |")
    print(f"| 6 - Voto em BRANCO (digite 6)      |")
    print(f"|____________________________________|")

    op = int(input(f"\n{x}º colaborador. Informe o seu voto: "))

    if op < 1 or op > 6:
        print("\nOPÇÃO INVÁLIDA")
        while op < 1 or op > 6:
            op = int(input(f"\n{x}º colaborador. Informe o seu voto: "))
    
    match op:
        case 1:
            cont1 += 1
        case 2:
            cont2 += 1
        case 3:
            cont3 += 1
        case 4:
            cont4 += 1
        case 5:
            nulo += 1
        case 6:
            branco += 1



print(f"\n\nTotal de votos para o(a) candidato 1: {cont1}")
print(f"Total de votos para o(a) candidato 2: {cont2}")
print(f"Total de votos para o(a) candidato 3: {cont3}")
print(f"Total de votos para o(a) candidato 4: {cont4}")
print(f"Total de votos nulos: {nulo}")
print(f"Total de votos em branco: {branco}")
print(f"Percentual de votos nulos: {(nulo / 20) * 100:.2f}%")
print(f"Percentual de votos em branco: {(branco / 20) * 100:.2f}%\n")