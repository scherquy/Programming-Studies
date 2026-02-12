#include <stdio.h>

int main(){

    int contador=0, valorUsuario;

    printf("\nInforme até que número você deseja que eu conte: ");
    scanf("%d", &valorUsuario);

    while(contador <= valorUsuario){
        printf("\n%d", contador);
        contador += 1;
    }
    printf("\n\n");

    return 0;
}