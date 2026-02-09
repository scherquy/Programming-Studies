#include <stdio.h>

int main(){

    float valorEmprestimo=0, totalPagar=0;
    int parcela=0;

    //20% de juros

    printf("\nInforme o valor do empréstimo: R$");
    scanf("%f", &valorEmprestimo);

    totalPagar = valorEmprestimo + ((20.0/100) * valorEmprestimo);

    printf("\nVocê pegou R$%.2f de empréstimo, o valor total a pagar é de R$%.2f. Deseja parcelar em quantas vezes? ", valorEmprestimo, totalPagar);
    scanf("%d", &parcela);

    printf("\nVocê vai pagar %.2f em %d parcelas de R$%.2f\n\n", totalPagar, parcela, (totalPagar/parcela));

    return 0;
}