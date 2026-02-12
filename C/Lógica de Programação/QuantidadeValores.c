#include <stdio.h>

int main(){

    int quantidadeValores=0, valor, somaImpares=0;

    printf("\n\nDigite valores para saber quantos estão entre 0 e 10\n");

    for(int x=0; x<6; x++){
        printf("\n%dº valor: ", x+1);
        scanf("%d", &valor);

        if(valor >= 0 && valor <= 10){
            quantidadeValores++;
        }

        if(valor%2 == 1){
            somaImpares += valor;
        }
    }

    printf("\n\n%d valores estão entre 0 e 10\n\n", quantidadeValores);
    printf("Soma dos valores ímpares digitados é igual a %d\n\n", somaImpares);

    return 0;
}