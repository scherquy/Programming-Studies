/* 80) Faça um algoritmo que preencha um vetor de 30 posições com números entre 1 e
15 sorteados pelo computador. Depois disso, peça para o usuário digitar um
número (chave) e seu programa deve mostrar em que posições essa chave foi
encontrada. Mostre também quantas vezes a chave foi sorteada. */

package ExercisesList.aleatorievector;

import java.util.Scanner;
import java.util.Arrays;
import java.math.*;

public class vector {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        int vector[] = new int[30];
        int key = 0, position = 0, quantityKey = 0;

        System.out.println();

        for(int x=0; x<vector.length; x++){
            vector[x] = (int)(1 + Math.random() * (15 - 1));
        }

        do{
            System.out.printf("Informe uma chave (valor inteiro entre 1 e 15): ");
            key = read.nextInt();

            if(key < 1 || key > 15){
                System.out.printf("\nKey INVÁLIDA. Informe um valor inteiro entre 1 e 15\n");
            }
        }while(key < 1 && key > 15);

        System.out.printf("\nNÚMEROS SORTEADOS -> ");
        for(int y=0; y<vector.length; y++){
            if(key == vector[y]){
                quantityKey++;
            }

            System.out.printf("%d ", vector[y]);
        }

        System.out.printf("\n\nA sua key foi encontrada %d vezes\n", quantityKey);
        System.out.printf("\nPosições em que a key foi encontrada:\n");

        for(int z=0; z<vector.length; z++){
            if(vector[z] == key){
                System.out.printf("\n%d está na posição %d", vector[z], z);
            }
        }
        System.out.printf("\n\n");
    }
}
