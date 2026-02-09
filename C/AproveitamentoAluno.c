#include <stdio.h>

int main(){

    float nota1, nota2, media;

    printf("\nInforme a 1º nota: ");
    scanf("%f", &nota1);
    printf("Informe a 2º nota: ");
    scanf("%f", &nota2);

    media = (nota1 + nota2) / 2;

    printf("\n--------------------");
    printf("\nMÉDIA: %.2f", media);
    
    if(media >= 9 && media <= 10){
        printf("\nAPROVEITAMENTO: A");
    }   else if(media >= 8 && media <= 8.99){
            printf("\nAPROVEITAMENTO: B");
    }   else if(media >= 7 && media <= 7.99){
            printf("\nAPROVEITAMENTO: C");
    }   else if(media >= 6 && media <= 6.99){
            printf("\nAPROVEITAMENTO: D");
    }   else if(media >= 5 && media <= 5.99){
            printf("\nAPROVEITAMENTO: E");
    }   else if(media >= 0 && media < 5){
            printf("\nAPROVEITAMENTO: F");
    }
    
    printf("\n--------------------\n\n");

    return 0;
}