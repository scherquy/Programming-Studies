#include <stdio.h>

int main(){

    char nome[15];

    printf("\nInforme o seu nome: ");
    scanf("%[^\n]", nome);

    printf("\nMuito prazer %s\n\n", nome);

    return 0;
}