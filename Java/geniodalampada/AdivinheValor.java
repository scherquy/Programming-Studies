package geniodalampada;

import java.util.Scanner;
import java.math.*;

public class AdivinheValor {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        int genieNumber = (int)(0 + Math.random() * (10 - 0));

        System.out.printf("\n\nEu sou o gênio da lâmpada... Estou pensando em um número entre 0 e 10.\n\nVocê consegue adivinhar em que número eu estou pensando? ");
        int number = read.nextInt();

        String answer = (number == genieNumber) ? "Eu pensei em " + genieNumber + ". Você acertou" : "Eu pensei em " + genieNumber + ". Você errou";

        System.out.printf("\n%s\n", answer);

    }
}
