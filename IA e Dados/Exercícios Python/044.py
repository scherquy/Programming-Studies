'''
Leia quantas notas serão informadas, peça cada nota em um loop e calcule a média.
Critério de conclusão: Não guarde todas as notas se não for necessário.
Desafio extra: Conte quantas ficaram acima da média depois criando uma versão com lista.
'''

nota = float(0)
somaNotas = float(0)
notasAcimaDaMedia = []
todasNotas = []
contador = int(0)

while (nota != -1):
    nota = float(input("\nInforme a nota: "))

    if (nota >= 0) and (nota <= 10):
        somaNotas += nota
        todasNotas.append(nota)

        if (nota >= 6) and (nota <= 10):
            notasAcimaDaMedia.append(nota)

        contador += 1

media = float(somaNotas / contador)

print(f"\nTodas as notas: {[f"{x:.2f}" for x in todasNotas]}")
print(f"Notas acima da média: {[f"{x:.2f}" for x in notasAcimaDaMedia]}")
print(f"Média geral: {media:.2f}\n")