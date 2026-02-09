#include <stdio.h>

int main(){

    float peso, altura, imc;

    printf("\n|            IMC            |          CLASSIFICAÇÕES          |");
    printf("\n|                           |                                  |");
    printf("\n| Menor do que 18.5         | Abaixo do peso                   |");
    printf("\n| 18.5 - 24.9               | Peso normal                      |");
    printf("\n| 25.0 - 29.9               | Excesso de peso                  |");
    printf("\n| 30.0 - 34.9               | Obesidade grau I                 |");
    printf("\n| 35.0 - 39.9               | Obesidade grau II                |");
    printf("\n| Maior ou igual a 40.0     | Obesidade grau III               |\n\n");

    printf("Informe o seu peso (kg): ");
    scanf("%f", &peso);
    printf("\nInforme a sua altura (m): ");
    scanf("%f", &altura);

    imc = (peso) / (altura * altura);

    if(imc > 0 && imc < 18.5){
        printf("\n\nIMC = %.2f\n\nVocê está abaixo do peso\n\n", imc);
    } else if(imc >= 18.5 && imc <= 24.9){
        printf("\n\nIMC = %.2f\n\nVocê está com o peso normal\n\n", imc);
    } else if(imc >= 25 && imc <= 29.9){
        printf("\n\nIMC = %.2f\n\nVocê está com excesso de peso\n\n", imc);
    } else if(imc >= 30 && imc <= 34.9){
        printf("\n\nIMC = %.2f\n\nVocê está com obesidade grau I\n\n", imc);
    } else if(imc >= 35 && imc <= 39.9){
        printf("\n\nIMC = %.2f\n\nVocê está com obesidade grau II\n\n", imc);
    } else if (imc >= 40){
        printf("\n\nIMC = %.2f\n\nVocê está com obesidade grau III\n\n", imc);
    } else {
        printf("\n\nIMC = %.2f\n\nVocê está morto!!!\n\n", imc);
    }

    return 0;
}