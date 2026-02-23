// Crie um programa que leia 6 números inteiros e no final mostre quantos deles
// são pares e quantos são ímpares.

#include <stdio.h>

int main(){

    int valor, quantidadePares=0, quantidadeImpares=0, contador = 0;

    printf("\n");

    while(contador<6){
        printf("%dº valor: ", contador+1);
        scanf("%d", &valor);

        if((valor%2)==0){
            quantidadePares++;
        }   else{
                quantidadeImpares++;
            }
        
        contador++;
    }

    printf("\nQuantidade de números pares digitados: %d", quantidadePares);
    printf("\nQuantidade de números ímpares digitados: %d\n\n", quantidadeImpares);

    return 0;
}