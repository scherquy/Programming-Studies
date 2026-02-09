#include <stdio.h>

int main(){

    char time1[30], time2[30];
    int golsTime1, golsTime2, diferencaDeGols = 0;

    printf("\nNome do time mandante: ");
    scanf("%[^\n]s", time1);
    setbuf(stdin, NULL);
    printf("Nome do time visitante: ");
    scanf("%[^\n]s", time2);

    printf("\nNúmero de gols do(a) %s: ", time1);
    scanf("%d", &golsTime1);
    printf("Número de gols do(a) %s: ", time2);
    scanf("%d", &golsTime2);

    if(golsTime1 >= golsTime2){
        diferencaDeGols = golsTime1 - golsTime2;
    } else{
        diferencaDeGols = golsTime2 - golsTime1;
    }

    printf("\n-------------------------");
    printf("\nDIFERENÇA DE GOLS: %d", diferencaDeGols);
    printf("\nSTATUS DA PARTIDA: ");

    switch(diferencaDeGols){
        case 0:
            printf("EMPATE");
            break;
        case 1:
        case 2:
        case 3:
            printf("PARTIDA NORMAL");
            break;
        default:
            printf("GOLEADA");
            break;
    }

    printf("\n-------------------------\n\n");

    return 0;
}