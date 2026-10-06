'''
Leia um número e mostre sua tabuada de 1 a 10.
Critério de conclusão: Formate cada linha como 7 x 3 = 21.
Desafio extra: Permita escolher o limite da tabuada.
'''

valor = int(input("\nInforme qual número você quer saber a tabuada: "))
limite = int(input("Informe até onde a tabuada deve ir: "))

print()
for x in range(0, limite+1, 1):
    resultado = valor * x
    print(f"{valor} x {x} = {resultado}")

print()