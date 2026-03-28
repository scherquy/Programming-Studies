package metodos;

import java.util.Scanner;

public class TesteMetodos {
    
    static void sum(int a, int b){
        int sum = a + b;

        System.out.printf("\n%d + %d = %d\n\n", a, b, sum);
    }

    static int subtracao(int a, int b){
        int sub = a - b;

        return sub;
    }

    public static void main(String[] args) {
        
        Scanner read = new Scanner (System.in);

        int val1, val2;

        System.out.printf("\nInforme o 1º valor: ");
        val1 = read.nextInt();

        System.out.printf("\nInforme o 2º valor: ");
        val2 = read.nextInt();

        sum(val1, val2);

        System.out.printf("%d - %d = %d\n\n", val1, val2, subtracao(val1, val2));
    }
}
