/*81) Crie um programa que leia a idade de 8 pessoas e guarde-as em um vetor. No
final, mostre:

a) Qual é a média de idade das pessoas cadastradas
b) Em quais posições temos pessoas com mais de 25 anos
c) Qual foi a maior idade digitada (podem haver repetições)
d) Em que posições digitamos a maior idade */

package ExercisesList.vectorages;

import java.util.Scanner;

public class VectorAges {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int position = 0, positionBigAge = 0, bigAge = 0, sumAges = 0;
        float averageAges = 0;
        int vector[] = new int[8];

        System.out.println();

        for(int x=0; x<vector.length; x++){
            System.out.printf("[%d] - Informe a idade: ", x+1);
            vector[x] = read.nextInt();

            sumAges += vector[x];

            if(vector[x] > bigAge){
                bigAge = vector[x];
            }
        }

        System.out.printf("\nMédia das idades digitadas: %.2f", (float)((float)sumAges/vector.length));
        
        System.out.printf("\n\nPosições do vetor em que a idade é maior do que 25 anos: ");
        for(int z=0; z<vector.length; z++){
            if(vector[z]>25){
                System.out.printf("%d ", z);
            }
        }

        System.out.printf("\n\nA maior idade digitada: %d", bigAge);

        System.out.printf("\n\nPosições em que a maior idade foi digitada: ");
        for(int y=0; y<vector.length; y++){
            if(vector[y] == bigAge){
                System.out.printf("%d ", y);
            }
        }

        System.out.printf("\n\n");
    }
}
