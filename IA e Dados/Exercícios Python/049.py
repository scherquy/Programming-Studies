'''
Leia 10 números e descubra o maior sem usar max().
Critério de conclusão: Inicialize sua variável de controle de forma segura.
Desafio extra: Descubra também o segundo maior.
'''

maior = None
menor = None
listaNumeros = []
temp = None
segundoMaior = None

for x in range(0, 10, 1):
    numero = int(input(f"\nInforme o {x+1}º valor: "))

    if (x == 0):
        maior = numero
        menor = numero
        segundoMaior = numero

    if (numero > maior):
        segundoMaior = maior
        maior = numero

    elif (numero < maior) and (numero > segundoMaior):
        segundoMaior = numero

    if (numero <= menor):
        menor = numero

    listaNumeros.append(numero)

print(f"\nLista de Números: {listaNumeros}")
print(f"\nMaior: {maior}")
print(f"Segundo maior: {segundoMaior}")
print(f"Menor: {menor}\n")