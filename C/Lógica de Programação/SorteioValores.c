// Desenvolva um programa que faça o sorteio de 20 números entre 0 e 10 e mostre na tela:
// a) Quais foram os números sorteados
// b) Quantos números estão acima de 5
// c) Quantos números são divisíveis por 3

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){

    int valor, acimaDeCinco=0, divisiveisPorTres=0, contador=0;

    srand(time(NULL));

    printf("\nValores sorteados: ");
    while(contador < 20){
        valor = (rand() % 11);
        printf("%d ", valor);

        if(valor > 5){
            acimaDeCinco++;
        }
        
        if((valor%3)==0 && valor != 0){
            divisiveisPorTres++;
        }
        
        contador++;
    }

    printf("\n\nQuantidade de números acima de 5 = %d", acimaDeCinco);
    printf("\nQuantidade de números divisíveis por 3 = %d\n\n", divisiveisPorTres);

    return 0;
}