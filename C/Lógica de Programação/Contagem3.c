// Crie um aplicativo que mostre na tela a seguinte contagem:
// 0 3 6 9 12 15 18 Acabou!

#include <stdio.h>

int main(){

    int contador = 0;

    printf("\n");

    while(contador <= 18){
        printf("%d ", contador);
        contador += 3;
    }

    printf("Acabou!\n\n");

    return 0;
}