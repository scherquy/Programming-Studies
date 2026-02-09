#include <stdio.h>

int main(){

    int valor;

    printf("\nInforme um valor: ");
    scanf("%d", &valor);

    printf("\nO sucessor de %d é %d", valor, valor+1);
    printf("\nO antecessor de %d é %d\n\n", valor, valor-1);

    return 0;
}