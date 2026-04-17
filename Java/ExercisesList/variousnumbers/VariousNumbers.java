/*63) Crie um programa usando a estrutura “faça enquanto” que leia vários números.
A cada laço, pergunte se o usuário quer continuar ou não. No final, mostre na
tela:
a) O somatório entre todos os valores
b) Qual foi o menor valor digitado
c) A média entre todos os valores
d) Quantos valores são pares */

package ExercisesList.variousnumbers;

import java.util.Scanner;

public class VariousNumbers {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        int number = 0, count = 0, sumValues = 0, quantityEven = 0, minorValue = 0;
        String option = "";

        do{
            System.out.printf("\n[%d] - Informe um valor: ", count+1);
            number = read.nextInt();

            if(count == 0){
                minorValue = number;
            }

            read.nextLine();

            sumValues += number;

            if(number < minorValue){
                minorValue = number;
            }

            if((number % 2) == 0){
                quantityEven++;
            }

            count++;

            System.out.printf("\nDeseja continuar informando valores (Sim ou Não)? ");
            option = read.nextLine();
        } while(option.charAt(0) != 'N' && option.charAt(0) != 'n');

        System.out.printf("\nSomatório entre todos os valores -> %d", sumValues);
        System.out.printf("\nO menor valor digitado -> %d", minorValue);
        System.out.printf("\nMédia entre todos os valores -> %.2f", (float) sumValues/count);
        System.out.printf("\nQuantidade de valores pares -> %d\n\n", quantityEven);
    }
}
