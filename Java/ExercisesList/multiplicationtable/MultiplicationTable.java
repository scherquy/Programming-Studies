/*66) Escreva um programa que leia um número qualquer e mostre a tabuada desse
número, usando a estrutura “para”.
Ex: Digite um valor: 5
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15 ... */

package ExercisesList.multiplicationtable;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        int value = 0, result = 0;

        System.out.printf("\nEnter a integer value: ");
        value = read.nextInt();

        for(int x=1; x<=10; x++){
            result = value * x;
            System.out.printf("\n%d * %d = %d", value, x, result);
        }

        System.out.printf("\n\n");

    }
}
