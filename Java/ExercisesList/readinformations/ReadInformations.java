/*53) Faça um programa que leia a idade e o sexo de 5 pessoas, mostrando no final:
a) Quantos homens foram cadastrados
b) Quantas mulheres foram cadastradas
c) A média de idade do grupo
d) A média de idade dos homens
e) Quantas mulheres tem mais de 20 anos */

package ExercisesList.readinformations;

import java.util.Scanner;

public class ReadInformations {
    public static void main(String[] args) {
        
        Scanner read = new Scanner (System.in);

        String gender;
        byte age = (byte) 0;
        byte counterFemale = (byte) 0;
        byte counterMale = (byte) 0;
        byte womemOverTwenty = (byte) 0;
        short sumMaleAges = (short) 0;
        short sumAges = (short) 0;

        for(int x=0; x<5; x++){
            System.out.printf("\n[%d] - Report your age: ", x+1);
            age = read.nextByte();

            read.nextLine();

            System.out.printf("[%d] - Report your gender (Male or Female): ", x+1);
            gender = read.nextLine();

            sumAges += age;

            if((gender.charAt(0) == 'M') || (gender.charAt(0) == 'm')){
                sumMaleAges += age;
                counterMale++;
            }   else if(gender.charAt(0) == 'F' || gender.charAt(0) == 'f'){
                    counterFemale++;
                }

            if((gender.charAt(0) == 'F' || gender.charAt(0) == 'f') && (age > 20)){
                womemOverTwenty++;
            }
        }

        System.out.printf("\nQuantidade de homens cadastrados: %d", (byte)(counterMale));
        System.out.printf("\nQuantidade de mulheres cadastradas: %d", (byte)(counterFemale));
        System.out.printf("\nMédia de idade do grupo: %.2f", (float)(sumAges/5));
        System.out.printf("\nMédia de idade dos homens: %.2f", (float)(sumMaleAges/counterMale));
        System.out.printf("\nQuantidade de mulheres acima dos 20 anos: %d\n\n", (byte)(womemOverTwenty));
    }
}
