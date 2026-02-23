// Faça um programa que leia 7 números inteiros e no final mostre o somatório entre eles.

#include <stdio.h>

int main(){

    int soma = 0, valor, contador=0;

    printf("\n");

    while(contador < 7){
        printf("%dº valor: ", contador+1);
        scanf("%d", &valor);

        soma += valor;
        contador++;
    }

    printf("\nSoma = %d\n\n", soma);

    return 0;
}