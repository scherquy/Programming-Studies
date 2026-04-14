/*54) Desenvolva um aplicativo que leia o peso e a altura de 7 pessoas, mostrando
no final:
a) Qual foi a média de altura do grupo
b) Quantas pessoas pesam mais de 90Kg
c) Quantas pessoas que pesam menos de 50Kg tem menos de 1.60m
d) Quantas pessoas que medem mais de 1.90m pesam mais de 100Kg. */

package ExercisesList.readweight;

import java.util.Scanner;

public class ReadWeight {
    public static void main(String[] args) {
        
        Scanner read = new Scanner (System.in);

        float weight = (float) 0; //Peso
        float height = (float) 0; //Altura
        float sumHeight = (float) 0; //somaAltura
        int overNinetyKg = (int) 0; //acima de 90 kg
        int underOneSixtyCm = (int) 0;
        int overOneHundredKg = (int) 0;
        int count = (int) 0;

        for(int x=0; x<7; x++){
            System.out.printf("\n[%d] - Enter your weight: ", x+1);
            weight = read.nextFloat();

            System.out.printf("[%d] - Enter your height: ", x+1);
            height = read.nextFloat();

            sumHeight += height;

            if(weight > 90){
                overNinetyKg++;
            }

            if(weight < 50 && height < 1.60){
                underOneSixtyCm++;
            }

            if(height > 1.90 && weight > 100){
                overOneHundredKg++;
            }

            count++;
        }

        System.out.printf("\nMédia de altura: %.2f", (float)sumHeight/count);
        System.out.printf("\nQuantidade de pessoas que pesam mais do que 90 KG: %d", (int)overNinetyKg);
        System.out.printf("\nQuantidade de pessoas que pesam menos de 50 Kg e medem menos de 1.60m: %d", (int)underOneSixtyCm);
        System.out.printf("\nQuantidade de pessoas que medem mais de 1.90m e pesam mais de 100 Kg: %d\n\n", (int)overOneHundredKg);
    }
}
