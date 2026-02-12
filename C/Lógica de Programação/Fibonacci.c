#include <stdio.h>

int main(){

    int Fibonacci = 0, anterior=0, atual=1;

    printf("\n%d %d ", anterior, atual);
    for(int x=0; x<13; x++){

        Fibonacci = anterior + atual;

        printf("%d ", Fibonacci);

        anterior = atual;
        atual = Fibonacci;
    }
    printf("\n\n");

    return 0;
}