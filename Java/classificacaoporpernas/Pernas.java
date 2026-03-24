package classificacaoporpernas;

import java.util.Scanner;

public class Pernas {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        String tipo = new String();

        System.out.printf("\nInforme o número de pernas: ");
        int pernas = (int) read.nextInt();

        switch (pernas) {
            case 1: tipo = "Saci"; break;
            case 2: tipo = "Bípede"; break;
            case 4: tipo = "Quadrúpede"; break;
            case 6, 8: tipo = "Aranha"; break;
            default: tipo = "ET"; break;
        }

        System.out.printf("\nNúmero de pernas: %d", pernas);
        System.out.printf("\nTipo: %s\n\n", tipo);
    }
}
