'''
Escreva um programa que pergunte sobre o preço de três produtos e indique qual é o produto mais barato para comprar
'''

prod1 = float(input("\nInforme o valor do produto: R$"))
prod2 = float(input("\nInforme o valor do produto: R$"))
prod3 = float(input("\nInforme o valor do produto: R$"))

if prod1 < prod2 and prod1 < prod3:
    print(f"\nO produto 1 é o mais barato. Custa R${prod1:.2f}\n")
elif prod2 < prod1 and prod2 < prod3:
    print(f"\nO produto 2 é o mais barato. Custa R${prod2:.2f}\n")
else:
    print(f"\nO produto 3 é o mais barato. Custa R${prod3:.2f}\n")