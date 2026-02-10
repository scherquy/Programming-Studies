// Faça um programa que leia a largura e o comprimento de um terreno
// retangular, calculando e mostrando a sua área em m². O programa também
// devemostrar a classificação desse terreno, de acordo com a lista abaixo:
// - Abaixo de 100m² = TERRENO POPULAR
// - Entre 100m² e 500m² = TERRENO MASTER
// - Acima de 500m² = TERRENO VIP

#include <stdio.h>

int main(){

    float largura, comprimento, area;

    printf("\n------------<<< ÁREA DOS TERRENOS >>>------------\n");
    printf("          Abaixo de 100m² - TERRENO POPULAR        \n");
    printf("         Entre 100m² e 500m² - TERRENO MASTER      \n");
    printf("            Acima de 500m² - TERRENO VIP           \n");
    printf("-------------------------------------------------\n");

    printf("\nInforme a largura do terreno: ");
    scanf("%f", &largura);
    printf("Informe o comprimento do terreno: ");
    scanf("%f", &comprimento);

    area = largura * comprimento;

    printf("\nA área do terreno é de %.2fm². ", area);

    if(area < 100){
        printf("É um TERRENO POPULAR\n\n");
    } else if(area >=100 && area <= 500){
        printf("É um TERRENO MASTER\n\n");
    } else {
        printf("É um TERRENO VIP\n\n");
    }

    return 0;
}