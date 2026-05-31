/*92) Crie uma lógica que leia um número inteiro e passe para um procedimento
ParOuImpar() que vai verificar e mostrar na tela se o valor passado como
parâmetro é PAR ou ÍMPAR. */

package ExercisesList.parouimpar;

import java.util.Scanner;

public class ParOuImpar {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        int value = 0;

        System.out.printf("\n\nInforme um valor: ");
        value = read.nextInt();

        ParOuImpar(value);
    }

    static void ParOuImpar(int value){
        if((value % 2) == 0){
            System.out.printf("\n%d é PAR\n\n", value);
        }   else{
                System.out.printf("\n%d é ÍMPAR\n\n", value);
        }
    }
}
