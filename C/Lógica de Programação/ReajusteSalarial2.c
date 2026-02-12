// Uma empresa precisa reajustar o salário dos seus funcionários, dando um
// aumento de acordo com alguns fatores. Faça um programa que leia o salário atual,
// o gênero do funcionário e há quantos anos esse funcionário trabalha na empresa.

// No final, mostre o seu novo salário, baseado na tabela a seguir:

// - Mulheres
// - menos de 15 anos de empresa: +5%
// - de 15 até 20 anos de empresa: +12%
// - mais de 20 anos de empresa: +23%
// - Homens
// - menos de 20 anos de empresa: +3%
// - de 20 até 30 anos de empresa: +13%
// - mais de 30 anos de empresa: +25%

#include <stdio.h>

int main(){

    float salarioAtual, novoSalario;
    char genero, nome[20];
    int anosDeEmpresa;

    printf("\nInforme o seu nome: ");
    scanf("%[^\n]", nome);
    setbuf(stdin, NULL);

    printf("\n%s informe o seu salário atual: ", nome);
    scanf("%f", &salarioAtual);
    setbuf(stdin, NULL);

    printf("\n%s informe o seu gênero (M ou F): ", nome);
    scanf("%c", &genero);

    printf("\n%s informe a quantos anos você trabalha na empresa: ", nome);
    scanf("%d", &anosDeEmpresa);

    printf("\n\n------------------<<< TABELA PARA O REAJUSTE SALARIAL >>>------------------");
    printf("\n|                                                                         |");
    printf("\n| MULHERES                           | HOMENS                             |");
    printf("\n| Menos de 15 anos de empresa: +5%%   | Menos de 20 anos de empresa: +3%%   |");
    printf("\n| De 15 até 20 anos de empresa: +12%% | De 20 até 30 anos de empresa: +13%% |");
    printf("\n| Mais de 20 anos de empresa: +23%%   | Mais de 30 anos de empresa: +25%%   |");
    printf("\n|                                                                         |");
    printf("\n---------------------------------------------------------------------------\n\n");

    switch(genero){
        case 'F':
        case 'f':
            if(anosDeEmpresa < 15){
                novoSalario = salarioAtual + ((5.0/100) * salarioAtual);
            }   else if(anosDeEmpresa >= 15 && anosDeEmpresa <= 20){
                    novoSalario = salarioAtual + ((12.0/100) * salarioAtual);
                }   else{
                        novoSalario = salarioAtual + ((23.0/100) * salarioAtual);
                    }
            break;

        case 'M':
        case 'm':
            if(anosDeEmpresa < 20){
                novoSalario = salarioAtual + ((3.0/100) * salarioAtual);
            }   else if(anosDeEmpresa >= 20 && anosDeEmpresa <= 30){
                    novoSalario = salarioAtual + ((13.0/100) * salarioAtual);
                }   else{
                        novoSalario = salarioAtual + ((25.0/100) * salarioAtual);
                    }
    }

    printf("\n%s seu novo salário, de acordo com a tabela, é de R$%.2f\n\n", nome, novoSalario);

    return 0;
}