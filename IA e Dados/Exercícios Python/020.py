'''
Leia renda mensal, percentual que será guardado e número de meses. Calcule quanto será acumulado sem juros.

Critério de conclusão: Mostre valor mensal e total.
'''

renda_mensal = float(input("\nInforme a sua renda mensal: R$ "))

percentual = float(input("Informe o percentual que vai ser guardado dessa renda: "))

meses = int(input("Informe por quantos meses você vai guardar esse percentual: "))

valor_acumulado = ((percentual / 100) * renda_mensal) * meses

print(f"\nVocê vai guardar R$ {((percentual / 100) * renda_mensal):.2f} por mês")
print(f"Ao final dos {meses} meses você vai ter guardado R$ {valor_acumulado:.2f}")