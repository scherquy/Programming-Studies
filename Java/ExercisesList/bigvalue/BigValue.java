/*91) Desenvolva um algoritmo que leia dois valores pelo teclado e passe esses
valores para um procedimento Maior() que vai verificar qual deles é o maior e
mostrá-lo na tela. Caso os dois valores sejam iguais, mostrar uma mensagem
informando essa característica. */

package ExercisesList.bigvalue;

import java.util.Scanner;

public class BigValue {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        int values[] = new int[2];

        System.out.println();

        for(int x=0; x<values.length; x++){
            System.out.printf("\nInforme o %dº valor: ", x+1);
            values[x] = read.nextInt();
        }

        Maior(values);

    }

    static void Maior(int values[]){
        int maior = values[0];
        
        for(int x=0; x<values.length; x++){
            if(values[x] > maior){
                maior = values[x];
            }
        }

        System.out.printf("\n%d é o maior valor\n\n", maior);
    }
}
