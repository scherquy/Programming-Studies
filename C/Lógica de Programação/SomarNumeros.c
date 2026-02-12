#include <stdio.h>

int main(){

    int soma=0, numero, contador=0, maior, menor;

    printf("\nDiga 10 números para serem somados\n\n");

    printf("\n%dº número: ", contador+1);
    scanf("%d", &numero);

    soma += numero;

    contador += 1;

    maior = menor = numero;

    while(contador < 10){
        printf("\n%dº número: ", contador+1);
        scanf("%d", &numero);

        if(numero >= maior){
            maior = numero;
        }   else if(numero <= menor){
                menor = numero;
            }

        soma += numero;

        contador += 1;
    }

    printf("\n\nA soma dos números é %d\n", soma);
    printf("\nO MAIOR número digitado foi %d\n", maior);
    printf("\nO MENOR número digitado foi %d\n\n", menor);

    return 0;
}