'''
Escreva um código que lê a lista abaixo e faça:

lista = [16, 14, 63, 65, 17, 99, 70, 11, 20, 48, 79, 32, 17, 89, 12, 25, 66]

    A leitura do tamanho da lista
    A leitura do maior e menor valor
    A soma dos valores da lista

Ao final exiba uma mensagem dizendo:
"A lista possui [tam] números em que o maior número é [maior] e o menor número é [menor]. A soma dos valores presentes nela é igual a [soma]"
'''

lista = [16, 14, 63, 65, 17, 99, 70, 11, 20, 48, 79, 32, 17, 89, 12, 25, 66]

def Maior_E_Menor_Valor(lista, maior, menor):
    for x in lista:
        if x > maior:
            maior = x
        
        if x < menor:
            menor = x
    
    return (maior, menor)

maior = -999
menor = 999

tamanhoLista = len(lista)
maior, menor = Maior_E_Menor_Valor(lista, maior, menor) 
somaLista = sum(lista)

print(f"\nA lista possui {tamanhoLista} números em que o maior número é {maior} e o menor número é {menor}. A soma dos valores presentes nela é igual a {somaLista}\n")