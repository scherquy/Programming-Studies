// Uma empresa de aluguel de carros precisa cobrar pelos seus serviços. O
// aluguel de um carro custa R$90 por dia para carro popular e R$150 por dia para
// carro de luxo. Além disso, o cliente paga por Km percorrido. Faça um programa
// que leia o tipo de carro alugado (popular ou luxo), quantos dias de aluguel e
// quantos Km foram percorridos. No final mostre o preço a ser pago de acordo com a
// tabela a seguir:

// - Carros populares (aluguel de R$90 por dia)
// - Até 100Km percorridos: R$0,20 por Km
// - Acima de 100Km percorridos: R$0,10 por Km

// - Carros de luxo (aluguel de R$150 por dia)
// - Até 200Km percorridos: R$0,30 por Km
// - Acima de 200Km percorridos: R$0,25 por Km

#include <stdio.h>

int main(){

    float kmsRodados, valorTotalAluguel;
    int diasAlugado, op;

    printf("\n-----<<< TABELA ALUGUEL DE CARROS >>>-----");
    printf("\n|                                        |");
    printf("\n| 1 - Carro popular                      |");
    printf("\n| 2 - Carro de luxo                      |");
    printf("\n|                                        |");
    printf("\n------------------------------------------");

    printf("\n\nInforme o tipo de carro que você vai alugar: ");
    scanf("%d", &op);

    printf("\nInforme por quantos dias esse carro foi alugado: ");
    scanf("%d", &diasAlugado);

    printf("\nInforme a quantidade de quilômetros percorridos por esse veículo: ");
    scanf("%f", &kmsRodados);

    switch(op){
        case 1:
            if(kmsRodados <= 100){
                valorTotalAluguel = (90.0 * diasAlugado) + (0.2 * kmsRodados);
            }   else{
                    valorTotalAluguel = (90.0 * diasAlugado) + (0.1 * kmsRodados);
                }
            
            printf("\nVocê utilizou o carro popular por %d dias e rodou por %.2f km, portanto o valor do aluguel é\nR$%.2f\n\n", diasAlugado, kmsRodados, valorTotalAluguel);
            break;
        
        case 2:
            if(kmsRodados <= 200){
                valorTotalAluguel = (150.0 * diasAlugado) + (0.3 * kmsRodados);
            }   else{
                    valorTotalAluguel = (150.0 * diasAlugado) + (0.25 * kmsRodados);
                }
            
            printf("\nVocê utilizou o carro de luxo por %d dias e rodou por %.2f km, portanto o valor do aluguel é\nR$%.2f\n\n", diasAlugado, kmsRodados, valorTotalAluguel);
            break;
    }

    return 0;
}