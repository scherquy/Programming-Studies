'''
Leia faturamento total e número de pedidos e calcule o ticket médio.

Desafio extra: Compare com uma meta de ticket médio informada pelo usuário.
'''

faturamento_total = float(input("\nInforme o faturamento total: "))
num_pedidos = float(input("Informe o número de pedidos: "))

if num_pedidos == 0:
    print("\nSEM PEDIDOS!!!\n")
    
else:
    meta = float(input("Informe a meta de ticket médio: "))

    ticket_medio = faturamento_total / num_pedidos

    print(f"\nO valor médio do ticket é de R$ {ticket_medio:.2f}")

    if ticket_medio >= meta:
        print("Ticket médio dentro da meta. Parabéns!!!\n")

    else:
        print("Ticket médio abaixo da meta. Bora buscar!!!\n")