'''
Leia vendas, meta e margem. Classifique o mês como excelente, bom, atenção ou crítico combinando atingimento da meta e
margem.
Critério de conclusão: Use and/or de forma explícita.
Desafio extra: Produza uma recomendação curta para cada caso.
'''

vendas = float(input("\nInforme o total de vendas: R$ "))
meta = float(input("Informe a meta de vendas: R$ "))
margem = float(input("Informe a margem percentual: "))

atingiu_meta = bool(vendas >= meta)

if atingiu_meta and margem >= 25:
    print(f"\nMês excelente. Mantenha a estratégia atual.\n")

elif atingiu_meta and margem < 25:
    print(f"\nMês bom. Revise os preços para aumentar a margem.\n")

elif not atingiu_meta and margem >= 25:
    print(f"\nAtenção. Precisa aumentar o número de vendas.\n")

else:
    print(f"\nMês crítico. Revisar metas, preços e estratégia comercial.\n")