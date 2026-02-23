// Escreva um programa que mostre na tela a seguinte contagem:
// 6 7 8 9 10 11 Acabou!

#include <stdio.h>

int main(){

    int contador = 6;

    printf("\n");
    while(contador <= 11){
        printf("%d ", contador);
        contador++;
    }

    printf("Acabou!\n\n");

    return 0;
}