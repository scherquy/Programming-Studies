// Crie um programa que leia o número de dias trabalhados em um mês e mostre o
// salário de um funcionário, sabendo que ele trabalha 8 horas por dia e ganha R$25
// por hora trabalhada

#include <stdio.h>

int main(){

    int diasTrabalhados;
    float salario;

    printf("\nInforme a quantidade de dias trabalhados no mês: ");
    scanf("%d", &diasTrabalhados);

    salario = diasTrabalhados * (8.0 * 25.0);

    printf("\nSeu salário nesse mês é de R$%.2f\n\n", salario);

    return 0;
}