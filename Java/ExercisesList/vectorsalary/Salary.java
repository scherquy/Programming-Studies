/* 85) Faça um algoritmo que leia o nome, o sexo e o salário de 5 funcionários e
guarde esses dados em três vetores. No final, mostre uma listagem contendo
apenas os dados das funcionárias mulheres que ganham mais de R$5 mil. */

package ExercisesList.vectorsalary;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        String names[] = new String[5];
        String gender[] = new String[5];
        float salary[] = new float[5];

        System.out.println();

        for(int x=0; x<gender.length; x++){
            System.out.printf("\n[%d] - Enter the name: ", x+1);
            names[x] = read.nextLine();

            System.out.printf("[%d] - Enter the gender (Male or Female): ", x+1);
            gender[x] = read.nextLine();

            System.out.printf("[%d] - Enter the salary: ", x+1);
            salary[x] = read.nextFloat();

            read.nextLine();
        }

        for(int z=0; z<names.length; z++){
            if((gender[z].charAt(0) == 'F' || gender[z].charAt(0) == 'f') && (salary[z] > 5000)){
                System.out.printf("\nName: %s\nGender: Female\nSalary: R$ %.2f\n", names[z], salary[z]);
            }
        }

        System.out.printf("\n");
    }
}
