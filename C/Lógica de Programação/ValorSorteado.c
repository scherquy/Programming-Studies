// Crie um jogo onde o computador vai sortear um número entre 1 e 5 o
// jogador vai tentar descobrir qual foi o valor sorteado.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){


    int valorSorteado, valorEscolhido;

    srand(time(NULL));

    valorSorteado = (rand() % 5) + 1;

    printf("\nTente adivinhar o valor sorteado (fica entre 1 e 5): ");
    scanf("%d", &valorEscolhido);

    if(valorEscolhido == valorSorteado){
        printf("\nVocê acertou. O valor sorteado foi %d\n\n", valorSorteado);
    }   else{
            printf("\nVocê errou. O valor sorteado foi %d\n\n", valorSorteado);
        }

    return 0;
}