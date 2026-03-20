package operadorternario;

import java.util.Scanner;

public class OperadorTernario {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        int value1, value2, bigger;

        System.out.printf("\n\nInforme o 1º valor: ");
        value1 = read.nextInt();

        System.out.printf("Informe o 2º valor: ");
        value2 = read.nextInt();

        bigger = (value1 > value2) ? value1 : value2;

        System.out.printf("\nO maior valor é: %d\n\n", bigger);
    }
}
