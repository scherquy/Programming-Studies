/*69) [DESAFIO] Desenvolva um programa que leia o primeiro termo e a razão de uma
PA (Progressão Aritmética), mostrando na tela os 10 primeiros elementos da PA e
a soma entre todos os valores da sequência. */

package ExercisesList.arithmeticprogression;

import java.util.Scanner;

public class ArithmeticProgression {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int firstNumber = 0, commonDiference = 0, sumPA = 0, PA = 0;

        System.out.printf("\nEnter first number: ");
        firstNumber = read.nextInt();

        System.out.printf("\nEnter commonDiference: ");
        commonDiference = read.nextInt();

        for(int x=1; x<=10; x++){
            PA = firstNumber + (x - 1) * commonDiference;

            System.out.printf("\n%dº Termo: %d", x, PA);
            sumPA += PA;
        }

        System.out.printf("\n\nSoma entre os valores da sequência: %d\n\n", sumPA);
        
    }
}
