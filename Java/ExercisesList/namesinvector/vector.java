/* 77) Faça um programa que leia 7 nomes de pessoas e guarde-os em um vetor. No
final, mostre uma listagem com todos os nomes informados, na ordem inversa
daquela em que eles foram informados. */

package ExercisesList.namesinvector;

import java.util.Arrays;
import java.util.Scanner;

public class vector {
    public static void main(String[] args) {
        
        String vector[] = new String[7];
        Scanner read = new Scanner(System.in);

        System.out.println();

        for(int x=0; x<7; x++){
            System.out.printf("[%d] - Informe o nome: ", x+1);
            vector[x] = read.nextLine();
        }

        System.out.printf("\nOrdem que os nomes foram informados:\n");
        for(int y=0; y<7; y++){
            System.out.printf("\n[%d] - %s", y+1, vector[y]);
        }

        System.out.printf("\n\nOrdem inversa da que os nomes foram informados:\n");
        for(int z=6; z>=0; z--){
            System.out.printf("\n[%d] - %s", z+1, vector[z]);
        }

        System.out.printf("\n\n");
    }
}
