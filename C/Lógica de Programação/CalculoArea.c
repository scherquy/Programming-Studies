// Faça um algoritmo que leia a largura e altura de uma parede, calcule e
// mostre a área a ser pintada e a quantidade de tinta necessária para o serviço,
// sabendo que cada litro de tinta pinta uma área de 2 metros quadrados.

#include <stdio.h>

int main(){

    float largura, altura, area, quantidadeTinta;

    printf("\nInforme a LARGURA da parede em metros: ");
    scanf("%f", &largura);

    printf("\nInforme a ALTURA da parede em metros: ");
    scanf("%f", &altura);

    area = largura * altura;

    printf("\nA área a ser pintada é de %.2f m²", area);

    quantidadeTinta = area / 2;

    printf("\nA quantidade de tinta necessária é de %.2f litros\n\n", quantidadeTinta);

    return 0;
}