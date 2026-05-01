/*82) Faça um algoritmo que leia a nota de 10 alunos de uma turma e guarde-as em
um vetor. No final, mostre:

a) Qual é a média da turma
b) Quantos alunos estão acima da média da turma
c) Qual foi a maior nota digitada
d) Em que posições a maior nota aparece */

package ExercisesList.vectorgrade;

import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        float grade[] = new float[10], sumGrades = 0, bigGrade = 0;
        int students = 0, position = 0;

        System.out.println();

        for(int x=0; x<grade.length; x++){
            System.out.printf("[%d] - Informe a nota: ", x+1);
            grade[x] = read.nextFloat();

            sumGrades += grade[x];

            if(grade[x] > bigGrade){
                bigGrade = grade[x];
            }
        }

        for(int z=0; z<grade.length; z++){
            if(grade[z] > ((float)(sumGrades/grade.length))){
                students++;
            }
        }

        System.out.printf("\n\nMédia da turma: %.2f", (float)(sumGrades/grade.length));
        System.out.printf("\nQuantidade de alunos acima da média da turma: %d", students);
        System.out.printf("\nMaior nota digitada: %.2f", bigGrade);
        System.out.printf("\nPosições em que a maior nota aparece: ");
        for(int y=0; y<grade.length; y++){
            if(bigGrade == grade[y]){
                System.out.printf("%d ", y);
            }
        }

        System.out.printf("\n\n");
    }
}
