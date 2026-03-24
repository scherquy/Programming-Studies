package ifelseswitch;

import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        System.out.printf("\nInforme um valor para saber se ele é PAR ou ÍMPAR: ");
        int number = read.nextInt();

        if((number % 2) == 0){
            System.out.printf("\n%d é PAR\n\n", number);
        }   else{
                System.out.printf("\n%d é ÍMPAR\n\n", number);
            }
    }
}
