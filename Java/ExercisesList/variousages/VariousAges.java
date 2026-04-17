/*62) Faça um programa usando a estrutura “faça enquanto” que leia a idade de
várias pessoas. A cada laço, você deverá perguntar para o usuário se ele quer ou
não continuar a digitar dados. No final, quando o usuário decidir parar, mostre
na tela:
a) Quantas idades foram digitadas
b) Qual é a média entre as idades digitadas
c) Quantas pessoas tem 21 anos ou mais. */

package ExercisesList.variousages;

import java.util.Scanner;

public class VariousAges {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        byte age = 0;
        String option = "";
        int quantityAges = 0, quantityPeople = 0, count = 0, sumAges = 0;

        do{
            System.out.printf("\n[%d] - Informe a idade: ", count+1);
            age = read.nextByte();

            read.nextLine();

            quantityAges++;
            sumAges += age;

            if(age >= 21){
                quantityPeople++;
            }

            count++;

            System.out.printf("\nDeseja continuar informando idades (Sim ou Não)? ");
            option = read.nextLine();
        }while(option.charAt(0) != 'N' && option.charAt(0) != 'n');

        System.out.printf("\nQuantidade de idades digitadas -> %d", quantityAges);
        System.out.printf("\nMédia entre as idades digitadas -> %.2f", (float) sumAges/count);
        System.out.printf("\nQuantidade de pessoas com 21 anos ou mais -> %d\n\n", quantityPeople);
    }
}
