// A locadora de carros precisa da sua ajuda para cobrar seus serviços. Escreva
// um programa que pergunte a quantidade de Km percorridos por um carro alugado e a
// quantidade de dias pelos quais ele foi alugado. Calcule o preço total a pagar,
// sabendo que o carro custa R$90 por dia e R$0,20 por Km rodado.

#include <stdio.h>

int main(){

    float kmsRodados, valorTotalAluguel;
    int diasAlugado;

    printf("\nInforme a quantidade de quilômetros percorridos por esse veículo: ");
    scanf("%f", &kmsRodados);

    printf("Informe por quantos dias esse carro foi alugado: ");
    scanf("%d", &diasAlugado);

    valorTotalAluguel = (diasAlugado * 90.0) + (kmsRodados * 0.2);

    printf("\nVocê utilizou o carro por %d dias e rodou por %.2f km, portanto o valor do aluguel é\nR$%.2f\n\n", diasAlugado, kmsRodados, valorTotalAluguel);

    return 0;
}