'''
Crie um programa que solicite à pessoa usuária digitar seu nome, idade e altura em metros, e imprima
“Olá, [nome], você tem [idade] anos e mede [altura] metros!”.
'''

nome = str(input("\nInforme o seu nome: "))
idade = int(input("Informe a sua idade: "))
altura = float(input("Informe a sua altura (em metros): "))

print(f"\nOlá, {nome}, você tem {idade} anos e mede {altura:.2f} metros\n")