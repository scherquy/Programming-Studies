// Faça um algoritmo que pergunte ao usuário um número inteiro e positivo
// qualquer e mostre uma contagem até esse valor:
// Ex: Digite um valor: 35
// Contagem: 1 2 3 4 5 6 7 ... 33 34 35 Acabou!

#include <stdio.h>

int main(){

    int valor, contador=1;

    printf("\nInforme um valor inteiro: ");
    scanf("%d", &valor);

    while(contador <= valor){
        printf("%d ", contador);
        contador++;
    }

    printf("Acabou!\n\n");

    return 0;
}