/*59) Crie um programa que leia o sexo e a idade de várias pessoas. O programa vai
perguntar se o usuário quer continuar ou não a cada pessoa. No final, mostre:
a) qual é a maior idade lida
b) quantos homens foram cadastrados
c) qual é a idade da mulher mais jovem
d) qual é a média de idade entre os homens */

package ExercisesList.genderandage;

import java.util.Scanner;

public class GenderAndAge {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        int age = 0, registeredMen = 0, biggerAge = 0, smallerAgeWoman = 999, sumMenAges = 0;
        String gender = "", option = "";

        do{
            System.out.printf("\nInforme o sexo (Homem ou Mulher): ");
            gender = read.nextLine();

            System.out.printf("Informe a idade: ");
            age = read.nextInt();

            read.nextLine();

            if(age > biggerAge){
                biggerAge = age;
            }

            if(gender.charAt(0) == 'H' || gender.charAt(0) == 'h'){
                registeredMen++;
                sumMenAges += age;
            }

            if((gender.charAt(0) == 'M' || gender.charAt(0) == 'm') && age < smallerAgeWoman){
                smallerAgeWoman = age;
            }

            System.out.printf("Deseja continuar cadastrando usuários (Sim ou Não)? ");
            option = read.nextLine();
        }while(option.charAt(0) != 'N' && option.charAt(0) != 'n');

        System.out.printf("\nMaior idade lida -> %d anos", biggerAge);
        System.out.printf("\nQuantidade de homens cadastrados: %d", registeredMen);
        System.out.printf("\nIdade da mulher mais jovem: %d anos", smallerAgeWoman);
        System.out.printf("\nMédia de idade entre os homens: %.2f anos\n\n", (float) sumMenAges/registeredMen);
    }
}
