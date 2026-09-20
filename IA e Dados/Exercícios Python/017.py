'''
Leia distância percorrida e litros consumidos e calcule km/l.

Critério de conclusão: Mostre duas casas decimais.

Desafio extra: Calcule custo por km com preço do combustível.
'''

distancia = float(input("\nInforme a distância percorrida (em KM): "))

litros = float(input("Informe os litros consumidos: "))

calculo = distancia / litros

preco_combustivel = 6.53

custo_por_km = preco_combustivel / calculo

print(f"\nKM / L: {calculo:.2f}\nCusto por KM: R$ {custo_por_km:.2f}\n")

