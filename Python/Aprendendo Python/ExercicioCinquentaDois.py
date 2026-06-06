'''
Com os mesmos dados da questão 51, defina quantas compras foram realizadas
acima de 3000 reais e calcule a porcentagem quanto ao total de compras.

gastos de uma empresa de papel
[2172.54, 3701.35, 3518.09, 3456.61, 3249.38, 2840.82, 3891.45, 3075.26, 2317.64, 3219.08].
'''

gastos = [2172.54, 3701.35, 3518.09, 3456.61, 3249.38, 2840.82, 3891.45, 3075.26, 2317.64, 3219.08]

cont = 0

for x in gastos:
    if x > 3000:
        cont += 1

porcentagem = (cont / len(gastos)) * 100

print(f"\n{cont} compras foram realizadas acima de R$3.000,00\n")
print(f"Porcentagem sobre o total de compras: {porcentagem:.2f}%\n")