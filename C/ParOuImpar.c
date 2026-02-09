#include <stdio.h>

int main(){

    int valor;

    printf("\nInforme um número: ");
    scanf("%d", &valor);

    if((valor % 2) == 0){
        printf("\n%d é par\n\n", valor);
    } else if ((valor % 2) == 1){
        printf("\n%d é ímpar\n\n", valor);
    }

    return 0;
}