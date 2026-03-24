package operadorternario;

import java.util.Scanner;
import java.time.LocalDate;

public class MaiorOuMenorDeIdade {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        short yearBirth, age, currentYear = (short) LocalDate.now().getYear();
        String major;

        System.out.printf("\n\nInforme o ano em que você nasceu: ");
        yearBirth = read.nextShort();

        age = (short)(currentYear - yearBirth);

        major = ((age > 18)) ? "MAIOR DE IDADE" : "MENOR DE IDADE";

        System.out.printf("\nIdade: %d anos", age);
        System.out.printf("\n%s\n\n", major);

    }
}
