// Desenvolva uma lógica que leia os valores de A, B e C de uma equação do
// segundo grau e mostre o valor de Delta.

#include <stdio.h>

int main(){

    float A, B, C, delta;

    printf("\n---------------------------------------------------");
    printf("\nCALCULADORA DO DELTA PARA EQUAÇÕES DO SEGUNDO GRAU");
    printf("\n---------------------------------------------------\n");

    printf("\nInforme o valor do A: ");
    scanf("%f", &A);
    printf("Informe o valor do B: ");
    scanf("%f", &B);
    printf("Informe o valor do C: ");
    scanf("%f", &C);

    delta = (B*B) - (4 * A * C);

    printf("\nO delta da equação de segundo grau (%.2fx²) + (%.2fx) + (%.2f) é %.2f\n\n", A, B, C, delta);

    return 0;
}