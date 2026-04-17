/*60) Desenvolva um algoritmo que leia o nome, a idade e o sexo de várias pessoas.
O programa vai perguntar se o usuário quer ou não continuar. No final, mostre:
a) O nome da pessoa mais velha
b) O nome da mulher mais jovem
c) A média de idade do grupo
d) Quantos homens tem mais de 30 anos
e) Quantas mulheres tem menos de 18 anos */

package ExercisesList.readinformations2;

import java.util.Scanner;

public class ReadInformations {
    public static void main(String[] args) {
    
        Scanner read = new Scanner(System.in);

        String name = "", gender = "", option = "", nameOlderPerson = "", nameYoungerWoman = "";
        byte age = 0, olderPerson = 0, youngerWoman = 127;
        int count = 0, countMen = 0, countWomen = 0, sumAges = 0;

        do{
            System.out.printf("\n[%d] - Informe o seu nome: ", count+1);
            name = read.nextLine();

            System.out.printf("%s informe a sua idade: ", name);
            age = read.nextByte();

            read.nextLine();

            System.out.printf("%s informe o seu sexo (Homem ou Mulher): ", name);
            gender = read.nextLine();

            if(age > olderPerson){
                olderPerson = age;
                nameOlderPerson = name;
            }

            if((gender.charAt(0) == 'M' || gender.charAt(0) == 'm')  && age < youngerWoman){
                youngerWoman = age;
                nameYoungerWoman = name;
            }

            if((gender.charAt(0) == 'H' || gender.charAt(0) == 'h') && age > 30){
                countMen++;
            }   else if((gender.charAt(0) == 'M' || gender.charAt(0) == 'm') && age < 18){
                    countWomen++;
                }

            sumAges += age;

            count++;

            System.out.printf("\nDeseja cadastrar mais usuários (Sim ou Não)? ");
            option = read.nextLine();

        }while(option.charAt(0) != 'N' && option.charAt(0) != 'n');

        System.out.printf("\n%s tem %d ano(s) e é a pessoa mais velha do grupo", nameOlderPerson, olderPerson);
        System.out.printf("\n%s tem %d ano(s) e é a mulher mais jovem do grupo", nameYoungerWoman, youngerWoman);
        System.out.printf("\nA média de idade do grupo é de %.2f ano(s)", (float) sumAges/count);
        System.out.printf("\n%d homens tem mais de 30 anos no grupo", countMen);
        System.out.printf("\n%d mulheres tem menos de 18 anos no grupo\n\n", countWomen);
    }
}
