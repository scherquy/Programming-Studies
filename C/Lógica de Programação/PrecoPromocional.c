// Crie um programa que leia o preço de um produto, calcule e mostre o seu
// PREÇO PROMOCIONAL, com 5% de desconto.

#include <stdio.h>

int main(){

    float valorProduto, valorPromocional;

    printf("\nInforme o valor do produto: ");
    scanf("%f", &valorProduto);

    valorPromocional = (valorProduto) - ((5.0/100.0) * valorProduto);

    printf("\nO valor com 5%% de desconto é R$%.2f\n\n", valorPromocional);

    return 0;
}