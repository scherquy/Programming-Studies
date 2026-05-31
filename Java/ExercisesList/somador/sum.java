/*90) Desenvolva um algoritmo que leia dois valores pelo teclado e passe esses
valores para um procedimento Somador() que vai calcular e mostrar a soma entre
eles. */

package ExercisesList.somador;

import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int values[] = new int[2];

        System.out.println();

        for(int x=0; x<values.length; x++){
            System.out.printf("\nInforme o %dº valor: ", x+1);
            values[x] = read.nextInt();
        }

        Somador(values);
    }

    static void Somador(int values[]){
        
        int result = 0;

        for(int x=0; x<values.length; x++){
            result += values[x];
        }

        System.out.printf("\n%d + %d = %d\n\n", values[0], values[1], result);
    }
}
