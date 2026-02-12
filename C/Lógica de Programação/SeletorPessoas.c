#include <stdio.h>

int main(){

    int idade, corCabelo, contadorMasculino=0, contadorFeminino=0;
    char sexo, op;

    do{
        printf("\nInforme o sexo (M/F): ");
        scanf(" %c", &sexo);

        printf("Informe a idade: ");
        scanf("%d", &idade);

        printf("Informe a cor do cabelo\n");
        printf("--------------------------");
        printf("\n1 - Preto");
        printf("\n2 - Castanho");
        printf("\n3 - Loiro");
        printf("\n4 - Ruivo\n\n");
        scanf("%d", &corCabelo);

        if((sexo == 'M' || sexo == 'm') && (idade > 18) && (corCabelo == 2)){
            contadorMasculino++;
        }   else if((sexo == 'F' || sexo == 'f') && (idade > 25 && idade < 30) && (corCabelo == 3)){
                contadorFeminino++;
            }

        printf("\nDeseja continuar (S/N)? ");
        scanf(" %c", &op);
        printf("\n==========================\n");

    }while (op != 'n' && op != 'N');

    printf("\n\nTotal de homens com mais de 18 anos e cabelos castanhos: %d", contadorMasculino);
    printf("\nTotal de mulheres entre 25 e 30 anos e cabelos loiros: %d\n\n", contadorFeminino);

    return 0;
}