#include <stdio.h>
#include <string.h>

int main(){

    int alunos;
    float nota=0, maiorNota=0;
    char nome[20], melhorAluno[20];

    printf("\nQuantos alunos tem na turma? ");
    scanf("%d", &alunos);

    for(int x=0; x<alunos; x++){
        setbuf(stdin, NULL);
        printf("\nInforme o nome do(a) aluno(a): ");
        scanf("%[^\n]", nome);

        printf("Informe a nota do(a) %s: ", nome);
        scanf("%f", &nota);

        if(nota >= maiorNota){
            maiorNota = nota;
            strcpy(melhorAluno, nome);
        }
    }

    printf("\n\nO melhor aproveitamento foi de %s com a nota %.2f\n\n", melhorAluno, maiorNota);

    return 0;
}