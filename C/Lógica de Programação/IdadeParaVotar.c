// Faça um programa que leia o ano de nascimento de uma pessoa, calcule a idade
// dela e depois mostre se ela pode ou não votar.

#include <stdio.h>

int main(){

    int idade;

    printf("\nInforme a sua idade: ");
    scanf("%d", &idade);

    if(idade < 16){
        printf("\nVocê tem %d anos. NÃO PODE VOTAR\n\n", idade);
    } else if(idade >= 16 && idade < 18  || idade > 70){
        printf("\nVocê tem %d anos. PODE VOTAR mas não é obrigatório\n\n", idade);
    } else {
        printf("\nVocê tem %d anos. Seu VOTO É OBRIGATÓRIO\n\n", idade);
    }

    return 0;
}