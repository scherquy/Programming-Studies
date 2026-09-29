'''
Crie variáveis para vendedor, vendas, meta e mês e gere uma frase de relatório com valores monetários e percentual atingido.

Critério de conclusão: A saída deve parecer algo que poderia ser enviado a um gestor.

Desafio extra: Use alinhamento ou separadores de milhar.
'''

mes = str(input("\nInforme o mês atual: "))
vendedor = str(input("Informe o nome do vendedor: "))
vendas = float(input(f"Informe o total de vendas de {vendedor.strip().title()}: R$ "))
meta = float(input(f"Informe a meta de vendas de {vendedor.strip().title()} para esse mês: R$ "))
porcentagem_meta = float((vendas * 100) / meta)

print(f"\n=== RELATÓRIO DE VENDAS ===")
print(f"{"Mês:":<12} {mes.strip().title():<5}")
print(f"{"Meta:":<12} {"R$":<2} {meta:.2f}")
print(f"{"Vendas:":<12} {"R$":<2} {vendas:.2f}")
print(f"{"Vendedor:":<12} {vendedor.strip().title():<5}")
print(f"{"% atingida:":<12} {porcentagem_meta:<5.2f} %\n")