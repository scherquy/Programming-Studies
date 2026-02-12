// Escreva um programa para aprovar ou não o empréstimo bancário para a compra
// de uma casa. O programa vai perguntar o valor da casa, o salário do comprador e
// em quantos anos ele vai pagar. Calcule o valor da prestação mensal, sabendo que
// ela não pode exceder 30% do salário ou então o empréstimo será negado.

#include <stdio.h>

int main(){

    float valorCasa, salario, prestacaoMensal;
    int anosPagamento, meses;
    char nome[20];

    printf("\nInforme o seu nome: ");
    scanf(" %[^\n]", nome);
    setbuf(stdin, NULL);
    printf("%s informe o valor da casa que você deseja comprar: ", nome);
    scanf("%f", &valorCasa);
    printf("%s informe o seu salário: ", nome);
    scanf("%f", &salario);
    printf("%s informe em quantos anos você deseja pagar a casa: ", nome);
    scanf("%d", &anosPagamento);

    meses = 12 * anosPagamento;

    prestacaoMensal = valorCasa / meses;

    printf("\n\n%s, o valor das prestações mensais são de R$%.2f. ", nome, prestacaoMensal);

    if(prestacaoMensal <= ((30.0/100) * salario)){
        printf("O seu empréstimo foi APROVADO\n\nVocê vai pagar %d prestações de R$%.2f\n\n", meses, prestacaoMensal);
    }   else{
            printf("O seu empréstimo NÃO FOI aprovado\n\nA prestação mensal excede 30%% do seu salário\n\n");
    }

    return 0;
}