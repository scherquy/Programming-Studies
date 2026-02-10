// Faça um algoritmo que pergunte a distância que um passageiro deseja
// percorrer em Km. Calcule o preço da passagem, cobrando R$0.50 por Km para
// viagens até 200Km e R$0.45 para viagens mais longas.

#include <stdio.h>

int main(){

    float quilometragem, precoPassagem;

    printf("\nInforme a quilometragem total da viagem: ");
    scanf("%f", &quilometragem);

    if(quilometragem > 0 && quilometragem <= 200){
        precoPassagem = quilometragem * 0.5;

        printf("\nA sua viagem tem %.2f KM e a sua passagem custa R$%.2f\n\n", quilometragem, precoPassagem);
    } else if(quilometragem > 200){
        precoPassagem = quilometragem * 0.45;

        printf("\nA sua viagem tem %.2f KM e a sua passagem custa R$%.2f\n\n", quilometragem, precoPassagem);
    }

    return 0;
}