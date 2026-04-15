/*56) Crie um programa que leia vários números pelo teclado e mostre no final o
somatório entre eles.
Obs: O programa será interrompido quando o número 1111 for digitado */

package ExercisesList.sumvalues;

import java.util.Scanner;

public class SumValues {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        long value = 0;
        long sumValues = 0;
        long count = 0;
        float averageValues = 0;

        do{
            System.out.printf("\nInforme o %dº valor: ", count+1);
            value = read.nextLong();

            if(value != 1111){
                sumValues += value;
                count++;
            }
        } while(value != 1111);

        averageValues = (float) sumValues/count;

        System.out.printf("\nA média dos valores é: %.2f\n\n", averageValues);
    }
}
