'''
Faça um código que colete em uma lista 5 números inteiros quaisquer e imprima a lista. Exemplo: [1,4,7,2,4].

Depois imprima a lista em ordem inversa à enviada.
'''

lista = []

print()
for x in range(0, 5, 1):
    val = int(input("Informe um valor: "))
    lista.append(val)

print()
print(lista)
print()
lista.sort(reverse = True)
print(lista)