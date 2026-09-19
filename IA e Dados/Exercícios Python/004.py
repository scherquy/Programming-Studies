'''
Leia largura e altura de um retângulo e calcule área e perímetro.
Critério de conclusão: Use nomes de variáveis descritivos.
Desafio extra: Calcule quantos metros de rodapé seriam necessários.
'''

largura = float(input("\nInforme a LARGURA do retângulo: "))
altura = float(input("Informe a ALTURA do retângulo: "))

area = float(largura * altura)
perimetro = float((2 * largura) + (2 * altura))

print(f"\nÁrea = {area} metros")
print(f"Perímetro = {perimetro} metros")
print(f"\nSão necessários {perimetro} metros de rodapé\n")