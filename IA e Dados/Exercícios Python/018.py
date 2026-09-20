'''
Leia horas trabalhadas no mês e valor por hora. Calcule salário bruto.

Critério de conclusão: Use valores reais.

Desafio extra: Adicione percentual de desconto e calcule líquido.
'''

horas_trabalhadas = float(input("\nInforme o total de horas trabalhadas no mês: "))

valor_por_hora = float(input("Informe o valor recebido por hora trabalhada: R$ "))

percentual_de_desconto = float(input("Informe o percentual de desconto salarial: "))

salario_bruto = horas_trabalhadas * valor_por_hora
salario_liquido = salario_bruto - ((percentual_de_desconto / 100) * salario_bruto)

print(f"\nVocê trabalhou {horas_trabalhadas:.2f} horas no mês")
print(f"Seu salário bruto é de R$ {salario_bruto:.2f}")
print(f"Seu salário líquido é de R$ {salario_liquido:.2f}\n")