#include <stdio.h>

int main(){

    int anoAtual, anoNascimento, idade;

    printf("\nInforme o ano atual: ");
    scanf("%d", &anoAtual);
    printf("\nInforme o ano que você nasceu: ");
    scanf("%d", &anoNascimento);

    idade = anoAtual - anoNascimento;

    printf("\nVocê tem %d anos. ", idade);

    if(idade >= 21){
        printf("Você é maior de idade!!!\n\n");
    } else{
        printf("Você é menor de idade!!!\n\n");
    }

    return 0;
}