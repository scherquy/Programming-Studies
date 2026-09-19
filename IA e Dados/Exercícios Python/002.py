'''
Leia dois números inteiros e mostre soma, diferença, produto e divisão.
Critério de conclusão: Converta corretamente a entrada antes dos cálculos.
Desafio extra: Trate o caso em que o segundo número é zero.
'''

val1 = int(input("\nEnter first number: "))
val2 = int(input("Enter second number: "))

sum = val1 + val2
sub = val1 - val2
mult = val1 * val2

print(f"\n{val1} + {val2} = {sum}")
print(f"{val1} - {val2} = {sub}")
print(f"{val1} * {val2} = {mult}")

if(val2 != 0):
    div = val1 / val2
    print(f"{val1} / {val2} = {div}\n")
else:
    print(f"Divisão por 0 é um número imaginário\n")