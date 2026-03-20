package calculadoraidade;

import java.util.Scanner;
import java.time.LocalDate;

public class CalculadoraIdade {
    public static void main(String[] args) {

        short yearBirth = (short) 0, age = (short) 0, currentYear = (short) LocalDate.now().getYear();
 
        Scanner read = new Scanner(System.in);

        System.out.printf("\n\nInforme o ano do seu nascimento: ");
        yearBirth = read.nextShort();

        age = (short) (currentYear - yearBirth);

        System.out.printf("\nVocê tem %d anos\n\n", age);   
    }
}
