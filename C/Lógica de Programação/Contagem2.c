// Faça um algoritmo que mostre na tela a seguinte contagem:
// 10 9 8 7 6 5 4 3 Acabou!

#include <stdio.h>

int main(){

    int contador = 10;

    printf("\n");

    while(contador >= 3){
        printf("%d ", contador);
        contador--;
    }

    printf("Acabou!\n\n");

    return 0;
}