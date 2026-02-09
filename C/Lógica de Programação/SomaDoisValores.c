#include <stdio.h>

int main(){

    int val1, val2;

    printf("\nInforme o 1º valor: ");
    scanf("%d", &val1);

    printf("Informe o 2º valor: ");
    scanf("%d", &val2);

    int soma = val1 + val2;

    printf("\n%d + %d = %d\n\n", val1, val2, soma);

    return 0;
}