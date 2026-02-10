#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){

    int jogadaPlayer, jogadaPC, pontuacaoPlayer = 0, pontuacaoPC = 0;
    char nome[20];

    srand(time(NULL));

    printf("\nInforme o seu nome: ");
    scanf("%[^\n]", nome);
    setbuf(stdin, NULL);

    printf("\n---------------------------------------------------------------------------\n\n");

    while(pontuacaoPC < 3 && pontuacaoPlayer < 3){
    printf("\n--<<< JOGADAS JOKENPO >>>--\n");
    printf("|                         |\n");
    printf("| 0 - PEDRA               |\n");
    printf("| 1 - PAPEL               |\n");
    printf("| 2 - TESOURA             |\n");
    printf("|                         |\n");
    printf("---------------------------\n");

    printf("\nInforme a sua jogada %s: ", nome);
    scanf("%d", &jogadaPlayer);

    switch(jogadaPlayer){
        case 0: printf("\nJogada do(a) %s foi PEDRA\n", nome); break;
        case 1: printf("\nJogada do(a) %s foi PAPEL\n", nome); break;
        case 2: printf("\nJogada do(a) %s foi TESOURA\n", nome); break;
    }

    jogadaPC = (rand() % 3);
    
    switch(jogadaPC){
        case 0: printf("\nJogada do PC foi PEDRA\n"); break;
        case 1: printf("\nJogada do PC foi PAPEL\n"); break;
        case 2: printf("\nJogada do PC foi TESOURA\n"); break;
    }

    if(jogadaPlayer == jogadaPC){
        switch(jogadaPlayer){
            case 0: printf("\nAmbos jogaram PEDRA\n"); break;
            case 1: printf("\nAmbos jogaram PAPEL\n"); break;
            case 2: printf("\nAmbos jogaram TESOURA\n"); break;
        }
    }   else if(jogadaPlayer == 0){
            if(jogadaPC == 1){
                pontuacaoPC += 1;
            } else if(jogadaPC == 2){
                pontuacaoPlayer += 1;
            }
        }   else if(jogadaPlayer == 1){
                if(jogadaPC == 0){
                    pontuacaoPlayer += 1;
                } else if(jogadaPC == 2){
                    pontuacaoPC += 1;
                }
            }   else if(jogadaPlayer == 2){
                    if(jogadaPC == 0){
                        pontuacaoPC += 1;
                    } else if(jogadaPC == 1){
                        pontuacaoPlayer += 1;
                    }
                }

    printf("\n%s: %d x %d :PC\n", nome, pontuacaoPlayer, pontuacaoPC);

    printf("\n---------------------------------------------------------------------------\n\n");
    }

    return 0;
}