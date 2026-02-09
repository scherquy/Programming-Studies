#include <stdio.h>

int main(){

    float numero;

    printf("\nInforme um valor para descobrir o seu DOBRO e a sua TERÇA PARTE: ");
    scanf("%f", &numero);

    printf("\nO dobro de %.2f é %.2f\n", numero, numero*2);
    printf("A terça parte de %.2f é %.2f\n\n", numero, numero/3);

    return 0;
}