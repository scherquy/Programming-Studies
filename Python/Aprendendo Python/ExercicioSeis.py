'''
Temos uma tabela de informação de empregos quanto ao cargo, quantidade de pessoas empregadas e o salário correspondente:

Cargo       Quantidade      Salário
Segurança       5            3000
Docente         16           6000
Diretoria       1            12500

Precisamos trabalhar com esses dados fornecendo:

    A quantidade total de empregados;
    A diferença entre o salário mais baixo e mais alto; e
    A média ponderada da faixa salarial da escola.

'''

seguranca = 5
salSeguranca = 3000.00

docente = 16
salDocente = 6000.00

diretoria = 1
salDiretoria = 12500.00

totalEmpregados = seguranca + docente + diretoria
diferencaSalario = salDiretoria - salSeguranca
mediaSalarial = ((seguranca * salSeguranca) + (docente * salDocente) + (diretoria * salDiretoria)) / (totalEmpregados)

print("\nQuantidade de Empregados da Escola: ", totalEmpregados)
print("Diferença Entre o Salário Mais Alto e Mais Baixo: R$ ", diferencaSalario)
print(f"Média Ponderada da Faixa Salarial da Escola: R$ {mediaSalarial:.2f}\n")