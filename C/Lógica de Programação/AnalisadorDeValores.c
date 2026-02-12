#include <stdio.h>

int main(){

    int somaValores=0, divisiveisPorCinco=0, nulos=0, somaPares=0, valor;
    float media=0, contador=0;

    for(int x=0; x<5; x++){
        printf("\nDigite o %dº valor: ", x+1);
        scanf("%d", &valor);

        somaValores += valor;

        if(valor%5 == 0){
            divisiveisPorCinco++;
        }

        if(valor == 0){
            nulos++;
        }

        if(valor%2 == 0){
            somaPares += valor;
        }

        contador++;
    }

    media = somaValores/contador;

    printf("\n\nSoma entre os valores: %d\n", somaValores);
    printf("Média entre os valores: %.2f\n", media);
    printf("Quantidade de valores divisíveis por cinco: %d\n", divisiveisPorCinco);
    printf("Quantidade de valores nulos: %d\n", nulos);
    printf("Soma dos valores pares: %d\n\n", somaPares);

    return 0;
}