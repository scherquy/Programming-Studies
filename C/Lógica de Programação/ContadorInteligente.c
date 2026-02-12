#include <stdio.h>

int main(){

    int valorInicio, valorFim;

    printf("\nInforme em qual valor o contador vai iniciar: ");
    scanf("%d", &valorInicio);

    printf("Informe em qual valor o contador vai parar: ");
    scanf("%d", &valorFim);

    int contador = valorInicio;

    if(valorInicio <= valorFim){
        while(contador <= valorFim){
            printf("\n%d", contador);
            contador++;
        }
    }   else{
            while(contador >= valorFim){
                printf("\n%d", contador);
                contador--;
            }
        }

    printf("\n\n");

    return 0;
}