// Faça um algoritmo que leia o salário de um funcionário, calcule e mostre o
// seu novo salário, com 15% de aumento.

#include <stdio.h>

int main(){

    float salarioAtual, novoSalario;

    printf("\nInforme o seu salário atual: ");
    scanf("%f", &salarioAtual);

    novoSalario = salarioAtual + ((15.0/100) * salarioAtual);

    printf("\nSeu novo salário com 15%% de aumento é de R$%.2f\n\n", novoSalario);

    return 0;
}