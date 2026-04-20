/*67) Faça um programa usando a estrutura “para” que leia um número inteiro
positivo e mostre na tela uma contagem de 0 até o valor digitado:
Ex: Digite um valor: 9
Contagem: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, FIM! */

package ExercisesList.counting2;

import java.util.Scanner;

public class counting {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        int value = 0;

        System.out.printf("\nEnter a value: ");
        value = read.nextInt();

        System.out.println();

        for(int x=0; x<=value; x++){
            System.out.printf("%d, ", x);
        }

        System.out.printf("FIM!\n\n");
    }
}
