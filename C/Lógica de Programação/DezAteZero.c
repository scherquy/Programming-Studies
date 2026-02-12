#include <stdio.h>

int main(){

    int contador = 12;

    while(contador > 0){
        contador -= 2;
        printf("\n%d", contador);
    }
    printf("\n\n");

    return 0;
}