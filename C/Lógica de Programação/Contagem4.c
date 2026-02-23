// Desenvolva um programa que mostre na tela a seguinte contagem:
// 100 95 90 85 80 ... 0 Acabou!

#include <stdio.h>

int main(){

    int contador = 100;

    printf("\n");

    while(contador >= 0){
        printf("%d ", contador);
        contador -= 5;
    }

    printf("Acabou! \n");

    return 0;
}