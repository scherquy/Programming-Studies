'''
Leia um inteiro não negativo e calcule seu fatorial sem usar biblioteca.
Critério de conclusão: 0! deve resultar em 1.
Desafio extra: Implemente uma versão com for e outra com while.
'''

fatorialWhile = int(1)

while True:
    val = int(input("\nInforme o inteiro que você quer saber o fatorial: "))
    valor_digitado = val

    if (val < 0):
        print("\nValor inválido. Informe um inteiro positivo.")
        continue
    
    elif (val == 0):
        fatorialWhile = 1

    while (val > 0):    
        fatorialWhile *= val

        val -= 1
    break

print(f"\n{valor_digitado}! = {fatorialWhile}\n")

################################################################################################

fatorialFor = int(1)

while True:
    valor = int(input("\nInforme o inteiro que você quer saber o fatorial: "))

    if (valor < 0):
        print("\nValor inválido. Informe um inteiro positivo.")
        continue

    elif (valor == 0):
        fatorialFor = 1

    for x in range(valor, 0, -1):
        fatorialFor *= x

    break

print(f"\n{valor}! = {fatorialFor}\n")