#include <stdio.h>

int main(){

    float real, dolar;

    // 1 dolar = 5,24 reais

    printf("\nQuantos reais você tem? ");
    scanf("%f", &real);

    dolar = real / 5.24;

    printf("\nCom R$%.2f da para comprar $%.2f\n\n", real, dolar);

    return 0;
}