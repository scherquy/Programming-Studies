/* 79) Desenvolva um programa que leia 10 números inteiros e guarde-os em um vetor.
No final, mostre quais são os números pares que foram digitados e em que
posições eles estão armazenados. */

package ExercisesList.vectoreven;

import java.util.Scanner;
import java.util.Arrays;

public class vector {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        int vector[] = new int[10];

        System.out.println();
        for(int x=0; x<vector.length; x++){
            System.out.printf("[%d] - Informe um valor inteiro: ", x+1);
            vector[x] = read.nextInt();
        }

        System.out.printf("\nVETOR -> ");
        for(int y=0; y<vector.length; y++){
            System.out.printf("%d ", vector[y]);
        }

        System.out.printf("\n\nValores pares e suas posições:\n");
        for(int z=0; z<vector.length; z++){
            int posicao = Arrays.binarySearch(vector, vector[z]);

            if((vector[z] % 2) == 0){
                System.out.printf("\n%d é PAR e está na %dº posição", vector[z], posicao);
            }
        }
        System.out.printf("\n\n");
    }
}
