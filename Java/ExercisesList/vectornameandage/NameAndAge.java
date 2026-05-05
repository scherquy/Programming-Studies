/* 84) Crie um programa que leia o nome e a idade de 9 pessoas e guarde esses
valores em dois vetores, em posições relacionadas. No final, mostre uma listagem
contendo apenas os dados das pessoas menores de idade. */

package ExercisesList.vectornameandage;

import java.util.Scanner;

public class NameAndAge {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        String names[] = new String[9];
        int ages[] = new int[9];

        System.out.println();

        for(int x=0; x<names.length; x++){
            System.out.printf("\n[%d] - Enter the name: ", x+1);
            names[x] = read.nextLine();

            System.out.printf("[%d] - Enter the Age: ", x+1);
            ages[x] = read.nextInt();

            read.nextLine();
        }

        for(int z=0; z<names.length; z++){
            if(ages[z] < 18){
                System.out.printf("\n%s tem %d anos", names[z], ages[z]);
            }
        }

        System.out.printf("\n\n");
    }
}
