/*58) Faça um algoritmo que leia a idade de vários alunos de uma turma. O programa
vai parar quando for digitada a idade 999. No final, mostre quantos alunos
existem na turma e qual é a média de idade do grupo. */

package ExercisesList.agestudents;

import java.util.Scanner;

public class AgeStudents {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        short age = 0;
        int count = 0, quantityStudents = 0, sumAges = 0;
        float averageAges = 0;

        do{
            System.out.printf("\nInforme a idade do %dº aluno: ", count+1);
            age = read.nextShort();

            if(age != 999){
                quantityStudents++;
                sumAges += age;
                count++;
            }
        }while(age != 999);

        averageAges = (float) sumAges/count;

        System.out.printf("\nExistem %d alunos na turma", quantityStudents);
        System.out.printf("\nA média das idades é de %.2f anos\n\n", averageAges);
    }
}
