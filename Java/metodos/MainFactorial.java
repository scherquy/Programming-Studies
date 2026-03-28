package metodos;

import java.util.Scanner;

public class MainFactorial {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        
        Factorial fac = new Factorial();

        System.out.printf("\nQuer saber o fatorial de qual valor? ");
        long value = read.nextLong();

        fac.setValor(value);

        System.out.printf("\n%s = %d\n\n", fac.getFormula(), fac.getResult());
    }
}
