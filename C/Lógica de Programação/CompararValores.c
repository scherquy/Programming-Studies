// Escreva um algoritmo que leia dois números inteiros e compare-os, mostrando
// na tela uma das mensagens abaixo:
// - O primeiro valor é o maior
// - O segundo valor é o maior
// - Não existe valor maior, os dois são iguais

#include <stdio.h>

int main(){

    int val1, val2;

    printf("\nInforme o 1º valor: ");
    scanf("%d", &val1);
    printf("Informe o 2º valor: ");
    scanf("%d", &val2);

    if(val1 > val2){
        printf("\nO primeiro valor é o maior\n\n");
    } else if(val2 > val1){
        printf("\nO segundo valor é maior\n\n");
    } else if(val1 == val2){
        printf("\nNão existe valor maior, os dois são iguais\n\n");
    }

    return 0;
}