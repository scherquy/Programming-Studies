'''
Leia salário atual e percentual de reajuste e informe novo salário e aumento em reais.

Calcule o salário anual antes e depois.
'''

sal_atual = float(input("\nInforme o seu salário atual: "))

percent_reajuste = float(input("\nInforme o percentual de reajuste salarial: "))

novo_salario = sal_atual + ((percent_reajuste/100) * sal_atual)

print(f"\nSeu salário aumentou em R$ {(percent_reajuste/100) * sal_atual:.2f}\nSeu novo salário é de R$ {novo_salario:.2f}")

print(f"\nSalário anual antes: R$ {sal_atual * 12:.2f}\nSalário anual depois: R$ {novo_salario * 12:.2f}\n")