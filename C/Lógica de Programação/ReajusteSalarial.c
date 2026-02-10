// Desenvolva um programa que leia o nome de um funcionário, seu salário,
// quantos anos ele trabalha na empresa e mostre seu novo salário, reajustado de
// acordo com a tabela a seguir:
// - Até 3 anos de empresa: aumento de 3%
// - entre 3 e 10 anos: aumento de 12.5%
// - 10 anos ou mais: aumento de 20%

#include <stdio.h>

int main(){

    char nome[20];
    float salarioAtual, novoSalario;
    int tempoDeEmpresa, op;

    printf("\nInforme o seu nome: ");
    scanf("%[^\n]", nome);
    printf("%s informe o seu salário atual: ", nome);
    scanf("%f", &salarioAtual);
    printf("%s a quantos anos você trabalha nessa empresa? ", nome);
    scanf("%d", &tempoDeEmpresa);

    printf("\n----------<<< TABELA DE REAJUSTE SALARIAL >>>----------\n");
    printf("|         Até 3 anos de empresa - AUMENTO DE 3%%        |\n");
    printf("|    Entre 3 e 10 anos de empresa - AUMENTO DE 12,5%%   |\n");
    printf("|      10 anos ou mais de empresa - AUMENTO DE 20%%     |\n");
    printf("-------------------------------------------------------\n\n");

    if(tempoDeEmpresa <= 3){
        novoSalario = salarioAtual + ((3.0/100) * salarioAtual);
    } else
        if(tempoDeEmpresa > 3 && tempoDeEmpresa <= 10){
            novoSalario = salarioAtual + ((12.5/100) * salarioAtual);
        } else {
            novoSalario = salarioAtual + ((20.0/100) * salarioAtual);
            }

    printf("%s seu novo salário é de R$%.2f\n\n", nome, novoSalario);

    return 0;
}