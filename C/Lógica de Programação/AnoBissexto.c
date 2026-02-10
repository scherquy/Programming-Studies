// Faça um algoritmo que leia um determinado ano e mostre se ele é ou não BISSEXTO.

#include <stdio.h>

int main(){

    int ano;

    printf("\nInforme o ano para saber se ele é bissexto: ");
    scanf("%d", &ano);

    if((ano % 400) == 0 || (ano % 4) == 0 && (ano % 100) != 0){
        printf("\n%d é um ano bissexto\n\n", ano);
    } else {
        printf("\n%d não é um ano bissexto\n\n", ano);
    }

    return 0;
}