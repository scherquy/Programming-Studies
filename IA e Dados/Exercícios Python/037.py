'''
Leia total gasto no ano e classifique cliente em Bronze, Prata, Ouro ou Diamante com limites definidos no enunciado do seu
programa.
Critério de conclusão: Exiba a faixa e quanto falta para a próxima.
Desafio extra: Se já estiver na maior faixa, informe isso.
'''

gasto_anual = float(input("\nInforme o total gasto no ano R$ "))

print(f"\n{" ":_<47}")
print(f"{"|":<47}|")
print(f"|{"Faixa":<15} {"Gasto Anual":<30}|")
print(f"{"|":<47}|")
print(f"|{"Bronze":<15} {"até R$500,00":<30}|")
print(f"|{"Prata":<15} {"de R$500,01 até R$2000,00":<30}|")
print(f"|{"Ouro":<15} {"de R$2.000,01 até R$10.000,00":<30}|")
print(f"|{"Diamante":<15} {"acima de R$10.000,00":<30}|")
print(f"|{"":_<46}|")

match gasto_anual:
    case a if a <= 500:
        print(f"\nVocê está na faixa BRONZE.")
        print(f"\nGaste mais R${500.01 - gasto_anual:.2f} para chegar em PRATA\n")

    case b if (b > 500) and (b <= 2000):
        print(f"\nVocê está na faixa PRATA.")
        print(f"\nGaste mais R${2000.01 - gasto_anual:.2f} para chegar em OURO\n")

    case c if (c > 2000) and (c <= 10000):
        print(f"\nVocê está na faixa OURO.")
        print(f"\nGaste mais R${10000.01 - gasto_anual:.2f} para chegar em DIAMANTE\n")

    case d if d > 10000:
        print(f"\nVocê está na faixa DIAMANTE.")
        print(f"\nVocê já está na maior faixa\n")