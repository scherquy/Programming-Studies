#include <stdio.h>

int main(){

    int valor, contador=0, somador=0;

    printf("\nPrograma para ver quantos números são negativos\n");

    do{
        printf("\nInforme o %dº número: ", contador+1);
        scanf("%d", &valor);

        if(valor < 0){
            somador++;
        }

        contador++;

    }while(contador < 5);

    printf("\n%d números são negativos\n\n", somador);

    return 0;
}