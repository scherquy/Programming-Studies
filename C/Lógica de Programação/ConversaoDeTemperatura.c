#include <stdio.h>

int main(){

    float celsius, fahrenheit;

    printf("\nInforme a temperatura em Fahrenheit: ");
    scanf("%f", &fahrenheit);

    celsius = (fahrenheit - 32) / 1.8;

    printf("\nA temperatura em graus Celsius é %.2f°\n\n", celsius);

    return 0;
}