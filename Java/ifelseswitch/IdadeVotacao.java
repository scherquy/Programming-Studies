package ifelseswitch;

import java.util.Scanner;
import java.time.LocalDate;

public class IdadeVotacao {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        short yearBirth, age, currentYear = (short)LocalDate.now().getYear();

        System.out.printf("\nInforme o ano em que você nasceu: ");
        yearBirth = read.nextShort();

        age = (short)(currentYear - yearBirth);

        if((age >= 16 && age <18) || age > 70){
            System.out.printf("\nVocê tem %d anos. Seu voto é OPCIONAL\n\n", age);
        }   else if(age < 16){
                System.out.printf("\nVocê tem %d anos. Você NÃO PODE votar\n\n", age);
            }   else{
                    System.out.printf("\nVocê tem %d anos. Seu voto é OBRIGATÓRIO\n\n", age);
                }
    }
}
