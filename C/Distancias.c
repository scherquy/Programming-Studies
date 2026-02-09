#include <stdio.h>

int main(){

    float distancia;

    printf("\nInforme uma distância (em metros): ");
    scanf("%f", &distancia);

    printf("A distância de %.2f corresponde a:\n\n%.5f Km\n%.4f Hm\n%.3f Dam\n%.2f dm\n%.2f cm\n%.2f mm\n\n", distancia, distancia/1000, distancia/100, distancia/10, distancia*10, distancia*100, distancia*1000);

    return 0;
}