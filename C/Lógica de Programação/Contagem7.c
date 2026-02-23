// Crie um algoritmo que leia o valor inicial da contagem, o valor final e o
// incremento, mostrando em seguida todos os valores no intervalo:
// Ex: Digite o primeiro Valor: 3
// Digite o último Valor: 10
// Digite o incremento: 2
// Contagem: 3 5 7 9 Acabou!

#include <stdio.h>

int main(){

    int primeiroValor, ultimoValor, incremento;

    printf("\nDigite o primeiro valor: ");
    scanf("%d", &primeiroValor);
    printf("Digite o último valor: ");
    scanf("%d", &ultimoValor);
    printf("Digite o incremento: ");
    scanf("%d", &incremento);

    printf("\n");

    if(primeiroValor >= ultimoValor){
        while(primeiroValor >= ultimoValor){
            printf("%d ", primeiroValor);
            primeiroValor -= incremento;
        }   
    }   else{
            while(primeiroValor <= ultimoValor){
                printf("%d ", primeiroValor);
                primeiroValor += incremento;
            }
        }

    printf("Acabou!\n\n");

    return 0;
}