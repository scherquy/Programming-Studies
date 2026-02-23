// Desenvolva um aplicativo que mostre na tela o resultado da expressão
// 500 + 450 + 400 + 350 + 300 + ... + 50 + 0

#include <stdio.h>

int main(){

    int contador = 500, soma = 0;

    printf("\n");

    while(contador >= 0){
        soma += contador;
        contador -= 50;
    }

    printf("Soma = %d\n\n", soma);

    return 0;
}