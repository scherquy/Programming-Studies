// Escreva um programa que leia o ano de nascimento de um rapaz e mostre a sua situação em relação ao alistamento militar.
// - Se estiver antes dos 18 anos, mostre em quantos anos faltam para o alistamento.
// - Se já tiver depois dos 18 anos, mostre quantos anos já se passaram do alistamento.

#include <stdio.h>

int main(){

    int anoNascimento, idade, tempoAlistamento;

    printf("\nInforme o ano que você nasceu: ");
    scanf("%d", &anoNascimento);

    idade = 2026 - anoNascimento;

    if(idade < 18){
        tempoAlistamento = 18 - idade;

        printf("\nVocê tem %d anos. Faltam %d ano(s) para se alistar ao exército\n\n", idade, tempoAlistamento);
    } else if (idade == 18){
        printf("\nVocê tem %d anos. Deve se alistar ao exército imediatamente\n\n", idade);
    } else{
        tempoAlistamento = idade - 18;

        printf("\nVocê tem %d anos. Já se passaram %d ano(s) do alistamento militar\n\n", idade, tempoAlistamento);
    }

    return 0;
}