// Escreva um programa para calcular a redução do tempo de vida de um
// fumante. Pergunte a quantidade de cigarros fumados por dias e quantos anos ele
// já fumou. Considere que um fumante perde 10 min de vida a cada cigarro. Calcule
// quantos dias de vida um fumante perderá e exiba o total em dias.

#include <stdio.h>

int main(){

    int quantidadeDeCigarros, anosFumando, diasFumando, cigarrosFumados;
    float diasDeVidaPerdidos;

    printf("\nQuantos cigarros você fuma por dia? ");
    scanf("%d", &quantidadeDeCigarros);

    printf("\nHá quantos anos você fuma? ");
    scanf("%d", &anosFumando);

    diasFumando = anosFumando * 365;

    diasDeVidaPerdidos = (quantidadeDeCigarros * diasFumando * 10.0) / 1440.0;

    cigarrosFumados = quantidadeDeCigarros * diasFumando;

    printf("\nVocê fumou %d cigarros e já perdeu %.2f dias de vida\n\n", cigarrosFumados, diasDeVidaPerdidos);

    return 0;
}