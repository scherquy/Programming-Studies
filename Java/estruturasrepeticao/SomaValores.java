package estruturasrepeticao;

import java.util.Scanner;

public class SomaValores {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        int value = (int) 0, sum = (int) 0;
        char prolong;

        do{
            System.out.printf("\nInforme um valor: ");
            value = read.nextInt();

            System.out.printf("Quer continuar informando valores (S/N)? ");
            prolong = read.next().charAt(0);

            sum += (int) value;
        } while(prolong == 'S' || prolong == 's');

        System.out.printf("\nA soma dos valores digitados é %d\n\n", sum);
    }
}
