'''
Leia média final e informe aprovado, recuperação ou reprovado usando faixas definidas por você e descritas no código.
Critério de conclusão: Nenhuma faixa pode ficar sem classificação.
Desafio extra: Considere também frequência mínima.
'''

media_final = float(input("\nInforme a média final do aluno: "))
frequencia = float(input("Informe a % de frequência do aluno: "))

if frequencia >= 75:
    if media_final >= 6:
        print(f"\nMédia Final: {media_final:.2f}")
        print(f"Frequência: {frequencia:.2f}%")
        print(f"\nAluno APROVADO. Parabéns.\n")

    elif (media_final < 6) and (media_final >= 2):
        print(f"\nMédia Final: {media_final:.2f}")
        print(f"Frequência: {frequencia:.2f}%")
        print(f"\nAluno em RECUPERAÇÃO. Precisa tirar no mínimo {float(12 - media_final):.2f} na recuperação para ser aprovado.\n")
    
    else:
        print(f"\nMédia Final: {media_final:.2f}")
        print(f"Frequência: {frequencia:.2f}%")
        print("\nAluno REPROVADO por nota.\n")

else:
    print(f"\nMédia Final: {media_final:.2f}")
    print(f"Frequência: {frequencia:.2f}%")
    print("\nAluno REPROVADO por frequência.\n")