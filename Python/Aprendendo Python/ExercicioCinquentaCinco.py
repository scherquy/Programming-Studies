'''
Para uma seleção de produtos alimentícios, precisamos separar o conjunto de IDs dados
por números inteiros sabendo que os produtos com ID par são doces e os com ID ímpar são amargos.
Monte um código que colete 10 IDs. Depois, calcule e mostre a quantidade de produtos doces e amargos.
'''

IDs = []
contDoces = 0
contAmargos = 0

print()
for x in range (0, 10, 1):
    IDs.append(int(input(f"Informe um ID do {x+1}º produto: ")))

for x in IDs:
    if (x % 2) == 0:
        contDoces += 1
    else:
        contAmargos += 1
    
print(f"\nQuantidade de produtos doces: {contDoces}")
print(f"Quantidade de produtos amargos: {contAmargos}\n")