#include <stdio.h>

int main(){

    int op;

    printf("\n-----<<< MENU >>>-----");
    printf("\n|                    |");
    printf("\n| 1 - De 1 até 10    |");
    printf("\n| 2 - De 10 até 1    |");
    printf("\n| 3 - Sair           |");
    printf("\n|                    |");
    printf("\n----------------------\n\n");

    printf("Escolha uma opção: ");
    scanf("%d", &op);

    switch(op){
        case 1:
            for(int x=0; x<10; x++){
                printf("\n%d", x+1);
            }
            printf("\n\n");
            break;
        case 2:
            for(int x=10; x>0; x--){
                printf("\n%d", x);
            }
            printf("\n\n");
            break;
        case 3:
            printf("\nVocê saiu\n\n");
            break;
    }

    return 0;
}