// Numa promoção exclusiva para o Dia da Mulher, uma loja quer dar descontos
// para todos, mas especialmente para mulheres. Faça um programa que leia nome,
// sexo e o valor das compras do cliente e calcule o preço com desconto. Sabendo que:
// - Homens ganham 5% de desconto
// - Mulheres ganham 13% de desconto

#include <stdio.h>

int main(){

    char nome[20], sexo;
    float valor, valorTotal;

    printf("\nInforme o seu nome: ");
    scanf("%[^\n]", nome);
    setbuf(stdin, NULL);
    printf("Informe o sexo (M ou F): ");
    scanf("%c", &sexo);
    printf("Informe o valor da compra: R$");
    scanf("%f", &valor);

    if(sexo == 'm' || sexo == 'M'){
        valorTotal = valor - ((5.0/100) * valor);
        printf("\n%s você recebeu 5%% de desconto e a sua compra ficou R$%.2f\n\n", nome, valorTotal);
    } else if(sexo == 'f' || sexo == 'F'){
        valorTotal = valor - ((13.0/100) * valor);
        printf("\n%s você recebeu 13%% de desconto e a sua compra ficou R$%.2f\n\n", nome, valorTotal);
    }

    return 0;
}