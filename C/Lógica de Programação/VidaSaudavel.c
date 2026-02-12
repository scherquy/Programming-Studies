// Um programa de vida saudável quer dar pontos atividades físicas que podem
// ser trocados por dinheiro. O sistema funciona assim:

// - Cada hora de atividade física no mês vale pontos

// - até 10h de atividade no mês: ganha 2 pontos por hora
// - de 10h até 20h de atividade no mês: ganha 5 pontos por hora
// - acima de 20h de atividade no mês: ganha 10 pontos por hora

// - A cada ponto ganho, o cliente fatura R$0,05 (5 centavos)

// Faça um programa que leia quantas horas de atividade uma pessoa teve por mês,
// calcule e mostre quantos pontos ela teve e quanto dinheiro ela conseguiu ganhar.

#include <stdio.h>

int main(){

    float horasAtividade, pontosGanhos, dinheiroGanho;
    char nome[20];

    printf("\nInforme o seu nome: ");
    scanf("%[^\n]", nome);
    setbuf(stdin, NULL);

    printf("\n%s informe quantas horas de atividades físicas você praticou no mês: ", nome);
    scanf("%f", &horasAtividade);

    if(horasAtividade <= 10){
        pontosGanhos = 2.0 * horasAtividade;
    }   else if(horasAtividade > 10 && horasAtividade <= 20){
            pontosGanhos = 5.0 * horasAtividade;
        }   else{
                pontosGanhos = 10.0 * horasAtividade;
            }

    dinheiroGanho = pontosGanhos * 0.05;

    printf("\n%s, você fez %.2f horas de atividades físicas no mês\nAcumulou %.2f pontos\nFaturou R$%.2f\n\n", nome, horasAtividade, pontosGanhos, dinheiroGanho);

    return 0;
}