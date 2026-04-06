/*51) Faça um aplicativo que leia o preço de 8 produtos. No final, mostre na tela
qual foi o maior e qual foi o menor preço digitados. */

package ExercisesList.readproducts;

import java.util.Scanner;

public class ReadProducts {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        double value = (double) 0;

        System.out.printf("\nInforme o valor do 1º produto: R$ ");
        value = read.nextDouble();

        double greaterValue = (double) value;
        double leastValue = (double) value;

        for(byte x=1; x<=7; x++){

            if(value >= greaterValue){
                greaterValue = value;
            }

            if(value <= leastValue){
                leastValue = value;
            }

            System.out.printf("\nInforme o valor do %dº produto: R$ ", x+1);
            value = read.nextDouble();
        }

        System.out.printf("\nO produto mais caro custa R$%.2f", greaterValue);
        System.out.printf("\n\nO produto mais barato custa R$%.2f\n\n", leastValue);
    }
}
