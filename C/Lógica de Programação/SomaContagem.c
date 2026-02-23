// Crie um programa que calcule e mostre na tela o resultado da soma entre
// 6 + 8 + 10 + 12 + 14 + ... + 98 + 100.

#include <stdio.h>

int main(){

    int contador = 6, soma = 0;

    printf("\n");

    while(contador <= 100){
        soma += contador;
        contador += 2;
    }

    printf("Soma = %d\n\n", soma);

    return 0;
}