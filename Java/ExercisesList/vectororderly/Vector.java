/*83) [DESAFIO] Crie uma lógica que preencha um vetor de 20 posições com números
aleatórios (entre 0 e 99) gerados pelo computador. Logo em seguida, mostre os
números gerados e depois coloque o vetor em ordem crescente, mostrando no final
os valores ordenados. */

package ExercisesList.vectororderly;

import java.util.Arrays;
import java.math.*;

public class Vector {
    public static void main(String[] args) {
        
        int vector[] = new int[20];

        System.out.printf("VECTOR -> ");
        for(int x=0; x<20; x++){
            vector[x] = (int)(0 + Math.random() * (99 - 0));

            System.out.printf("%d ", vector[x]);
        }

        Arrays.sort(vector);

        System.out.printf("\n\nVETOR ORDENADO -> ");
        for(int value : vector){
            System.out.printf("%d ", value);
        }

        System.out.printf("\n\n");
    }
}
