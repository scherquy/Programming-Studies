#include <stdio.h>

int main(){

    float l1, l2, l3;

    printf("\nInforme o lado 1: ");
    scanf("%f", &l1);
    printf("\nInforme o lado 2: ");
    scanf("%f", &l2);
    printf("\nInforme o lado 3: ");
    scanf("%f", &l3);

    if(l1<l2+l3 && l2<l1+l3 && l3<l1+l2){
        if(l1==l2 && l2==l3){
            printf("\nÉ UM TRIÂNGULO EQUILÁTERO!!!\n\n");
        } else if(l1!=l2 && l1!=l3 && l2!=l3){
            printf("\nÉ UM TRIÂNGULO ESCALENO!!!\n\n");
        } else if((l1 == l2 && l1 != l3) || (l2 == l3 && l2 != l1)){
            printf("\nÉ UM TRIÂNGULO ISÓSCELES\n\n");
        }
    } else {
        printf("\nCOM ESSES VALORES NÃO É POSSÍVEL FORMAR UM TRIÂNGULO!!!\n\n");
    }

    return 0;
}