/*76) Crie um programa que preencha automaticamente um vetor numérico com 7
números gerados aleatoriamente pelo computador e depois mostre os valores
gerados na tela. */

package ExercisesList.vectoraleatories;

import java.math.*;;

public class vector {
    public static void main(String[] args) {
        
        int vector[] = new int[7];

        System.out.println();

        for(int x=0; x<7; x++){
            vector[x] = (int)(0 + Math.random() * (99 - 0));

            System.out.printf("%d ", vector[x]);
        }

        System.out.printf("\n\n");
    }
}
