// Escreva um programa que pergunte a velocidade de um carro. Caso ultrapasse
// 80Km/h, exiba uma mensagem dizendo que o usuário foi multado. Nesse caso, exiba
// o valor da multa, cobrando R$5 por cada Km acima da velocidade permitida.

#include <stdio.h>

int main(){

    float velocidade, valorMulta;

    printf("\nInforme a velocidade do veículo em km/h: ");
    scanf("%f", &velocidade);

    if(velocidade > 80){
        valorMulta = (velocidade - 80) * 5;

        printf("\nVOCÊ FOI MULTADO. A sua velocidade era de %.2fkm/h em uma rodovia que a velocidade máxima é de 80km/h\n\nO valor da multa é de R$%.2f\n\n", velocidade, valorMulta);
    } else{
        printf("\n%.2fkm/h está dentro da velocidade permitida\n\n", velocidade);
    }

    return 0;
}