/*78) Escreva um programa que leia 15 números e guarde-os em um vetor. No final,
mostre o vetor inteiro na tela e em seguida mostre em que posições foram
digitados valores que são múltiplos de 10. */

package ExercisesList.positioninvector;

import java.util.Scanner;
import java.util.Arrays;

public class vector {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        int vector[] = new int[15];

        System.out.println();

        for(int x=0; x<vector.length; x++){
            System.out.printf("[%d] - Informe um valor inteiro: ", x+1);
            vector[x] = read.nextInt();
        }

        System.out.printf("\nVetor Inteiro -> ");
        for(int y=0; y<vector.length; y++){
            System.out.printf("%d ", vector[y]);
        }

        System.out.printf("\n\nPosições onde estão os múltiplos de 10:\n");
        for(int z=0; z<vector.length; z++){
            if((vector[z] % 10) == 0){
                int posicao = Arrays.binarySearch(vector, vector[z]);
                System.out.printf("\n%d está na %dº posição", vector[z], posicao);
            }
        }

        System.out.printf("\n\n");
    }
}
