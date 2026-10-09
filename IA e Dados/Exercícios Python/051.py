'''
Crie uma lista vazia e permita adicionar 5 itens digitados pelo usuário. Exiba a lista final.
Critério de conclusão: Use append.
Desafio extra: Permita remover um item informado.
'''

lista = []

print()
for x in range(0, 5, 1):
    item = input(f"Informe o {x+1}º item: ")

    lista.append(item)

while True:
    op = str(input(f"\nDeseja remover algum item da lista: "))

    if (op[0].lower() == "s"):
        print(f"\nLista de itens: {lista}")
        remover = str(input("\nO que você deseja remover? "))

        lista.remove(remover)

    elif (op[0].lower() == "n"):
        print(f"\nLista de itens: {lista}\n")
        break

    else:
        print("\nOpção Inválida.")