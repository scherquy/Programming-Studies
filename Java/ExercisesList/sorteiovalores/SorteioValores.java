/*50) Desenvolva um programa que faça o sorteio de 20 números entre 0 e 10 e
mostre na tela:
a) Quais foram os números sorteados
b) Quantos números estão acima de 5
c) Quantos números são divisíveis por 3 */

package ExercisesList.sorteiovalores;

import java.math.*;

public class SorteioValores {
    public static void main(String[] args) {
        
        byte x = (byte) 0;
        byte values = (byte) 0;
        byte graterThanFive = (byte) 0;
        byte divisibleByThree = (byte) 0;

        System.out.println();
        System.out.printf("Valores Sorteados: ");
        do{
            values = (byte) (0 + Math.random() * (10 - 0));

            System.out.printf("%d ", values);

            if(values > 5){
                graterThanFive++;
            }

            if((values % 3) == 0){
                divisibleByThree++;
            }

            x++;
        } while(x < 20);

        System.out.printf("\n\nQuantidade de números acima de 5 -> %d", graterThanFive);
        System.out.printf("\nQuantidade de números divisíveis por 3 -> %d\n\n", divisibleByThree);
    }
}
