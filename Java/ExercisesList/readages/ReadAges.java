/*52) Crie um algoritmo que leia a idade de 10 pessoas, mostrando no final:
a) Qual é a média de idade do grupo
b) Quantas pessoas tem mais de 18 anos
c) Quantas pessoas tem menos de 5 anos
d) Qual foi a maior idade lida */

package ExercisesList.readages;

import java.util.Scanner;

public class ReadAges {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        byte age = (byte) 0;
        byte counter = (byte) 0;
        byte majorEighteenYears = (byte) 0;
        byte minorFiveYears = (byte) 0;
        byte greaterAge = (byte) 0;
        short totalAges = (short) 0;
        float averageAges = (float) 0;

        for(int x=0; x<10; x++){
            System.out.printf("\nInforme a %dº idade: ", x+1);
            age = read.nextByte();

            totalAges += age;

            if(age > 18){
                majorEighteenYears++;
            }

            if(age < 5){
                minorFiveYears++;
            }

            if(age > greaterAge){
                greaterAge = age;
            }

            counter++;
        }

        averageAges = (float) (totalAges / counter);

        System.out.printf("\nA média de idade é %.2f anos", averageAges);
        System.out.printf("\n%d pessoas tem mais de 18 anos", majorEighteenYears);
        System.out.printf("\n%d pessoas tem menos de 5 anos", minorFiveYears);
        System.out.printf("\n%d foi a maior idade lida\n\n", greaterAge);
    }
}
