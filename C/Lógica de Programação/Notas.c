#include <stdio.h>

int main(){

    float nota1, nota2, media;

    printf("\nInforme a 1° nota: ");
    scanf("%f", &nota1);
    printf("Informe a 2° nota: ");
    scanf("%f", &nota2);

    media = (nota1 + nota2) / 2;

    if(media >= 6){
        printf("\nMÉDIA: %.2f\nALUNO APROVADO!!!\n\n", media);
    } else if(media < 6 && media >= 2){
        printf("\nMÉDIA: %.2f\nALUNO EM RECUPERAÇÃO!!!\n\n", media);
    } else {
        printf("\nMÉDIA: %.2f\nALUNO REPROVADO!!!\n\n", media);
    }

    return 0;
}