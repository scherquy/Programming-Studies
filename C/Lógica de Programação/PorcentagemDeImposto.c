#include <stdio.h>

int main(){

    float valorProduto, valorImposto, porcentagemImposto;

    printf("\nQual a porcentagem de imposto? ");
    scanf("%f", &porcentagemImposto);
    printf("\nValor do produto: R$");
    scanf("%f", &valorProduto);

    valorImposto = (porcentagemImposto / 100) * valorProduto;

    printf("\nVocê vai pagar R$%.2f de imposto\n\n", valorImposto);

    return 0;
}