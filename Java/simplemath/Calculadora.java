package simplemath;

import java.util.Scanner;
import java.math.*;

public class Calculadora {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        System.out.printf("\n\nInforme um valor: ");
        double value = read.nextDouble();

        byte remainder = (byte)(value%2);
        double cubeSth = (double)(Math.pow(value, 3));
        double squareRoot = (double)(Math.sqrt(value));
        double cubeRoot = (double)(Math.cbrt(value));
        long absoluteValue = (long)(Math.abs(value));

        System.out.printf("\n\nResto da divisão de %.2f por 2: %d", value, remainder);
        System.out.printf("\n%.2f elevado ao cubo: %.2f", value, cubeSth);
        System.out.printf("\nRaiz quadrada de %.2f: %.2f", value, squareRoot);
        System.out.printf("\nRaiz cúbica de %.2f: %.2f", value, cubeRoot);
        System.out.printf("\nValor absoluto de %.2f: %d\n\n", value, absoluteValue);
    }
}
