#include <stdio.h>

int main(){

    int valorInicial, valorFinal;

    printf("\nVamos combinar valores de um intervalo\n\n");

    printf("Informe o valor inicial: ");
    scanf("%d", &valorInicial);

    printf("Informe o valor final: ");
    scanf("%d", &valorFinal);

    if(valorInicial <= valorFinal){
        for(int x=valorInicial; x<=valorFinal; x++){
            for(int y=valorInicial; y<=valorFinal; y++){
                printf("%d, %d\n", x, y);
            }
            printf("\n");
        }
    }   else{
            for(int x=valorInicial; x>=valorFinal; x--){
                for(int y=valorFinal; y<=valorInicial; y++){
                    printf("%d, %d\n", x, y);
                }
                printf("\n");
            }
        }

    return 0;
}

// Tinha que fazer combinações de 2 digitos do valor inicial com o valor final
// No primeiro if foi mais de boa porque o valor inicial é menor do que o final
// aí é só fazer em ordem crescente, no segundo if como o inicial é maior do que o
// final eu comecei pelo maior e inverti a ordem do y para ficar certinho o x em
// ordem decrescente e o y em ordem crescente, fiz também pra ficar igual ao primeiro
// if mas achei que ia ficar sem graça, basicamente era só fazer isso

// for(int x=valorFinal; x<=valorInicial; x++){
//    for(int y=valorFinal; y<=valorInicial; y++){
//        printf("%d, %d\n", x, y);
//    }
//    printf("\n");
// }