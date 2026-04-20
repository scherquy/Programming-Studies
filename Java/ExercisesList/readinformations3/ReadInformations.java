/*68) Crie um programa que leia sexo e peso de 8 pessoas, usando a estrutura
“para”. No final, mostre na tela:
a) Quantas mulheres foram cadastradas
b) Quantos homens pesam mais de 100Kg
c) A média de peso entre as mulheres
d) O maior peso entre os homens */

package ExercisesList.readinformations3;

import java.util.Scanner;

public class ReadInformations {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        String gender = "";
        float weight = 0, greaterManWeight = 0, sumWomenWeight = 0;
        int totalWomen = 0, totalMen = 0, countWomen = 0;

        for(int x=0; x<8; x++){
            System.out.printf("\n[%d] - Enter weight (KG): ", x+1);
            weight = read.nextFloat();

            read.nextLine();

            System.out.printf("[%d] - Enter gender (Man or Woman): ", x+1);
            gender = read.nextLine();

            if(gender.charAt(0) == 'W' || gender.charAt(0) == 'w'){
                sumWomenWeight += weight;
                totalWomen++;
                countWomen++;
            }

            if(gender.charAt(0) == 'M' || gender.charAt(0) == 'm'){
                if(weight > 100){
                    totalMen++;
                }

                if(weight > greaterManWeight){
                    greaterManWeight = weight;
                }
            }
        }

        System.out.printf("\nTotal de mulheres cadastradas: %d", totalWomen);
        System.out.printf("\nTotal de homens com mais de 100kg: %d", totalMen);
        System.out.printf("\nMédia de peso entre as mulheres: %.2f", (float) sumWomenWeight/countWomen);
        System.out.printf("\nO maior peso entre os homens: %.2f\n\n", greaterManWeight);
    }
}
