#include <stdio.h>

int main(){

    int anoAtual, anoNascimento, idade;

    printf("\n--------------------");
    printf("\n       DETRAN       ");
    printf("\n--------------------");

    printf("\nInforme o ano atual: ");
    scanf("%d", &anoAtual);
    printf("Informe o ano que você nasceu: ");
    scanf("%d", &anoNascimento);

    idade = anoAtual - anoNascimento;

    if(idade >= 18){
        printf("\n--------------------");
        printf("\n       DETRAN       ");
        printf("\n--------------------");
        printf("\nIDADE: %d ANOS", idade);
        printf("\nAPTO A TIRAR CARTEIRA DE MOTORISTA\n\n");
    } else if(idade >= 0 && idade < 18){
        printf("\n--------------------");
        printf("\n       DETRAN       ");
        printf("\n--------------------");
        printf("\nIDADE: %d ANOS", idade);
        printf("\nINAPTO A TIRAR CARTEIRA DE MOTORISTA\n\n");
    } else {
        printf("\n--------------------");
        printf("\n       DETRAN       ");
        printf("\n--------------------");
        printf("\nIDADE: %d ANOS", idade);
        printf("\nVOCÊ NÃO EXISTE!!!\n\n");
    }

    return 0;
}