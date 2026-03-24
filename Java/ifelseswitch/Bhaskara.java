package ifelseswitch;

import java.util.Scanner;
import java.math.*;

public class Bhaskara {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        System.out.printf("\nInforme o 'a': " );
        double a = read.nextDouble();

        if(a == 0){
            System.out.printf("\n'a' tem que ser diferente de 0\n\n");
            return;
        }

        System.out.printf("Informe o 'b': " );
        double b = read.nextDouble();

        System.out.printf("Informe o 'c': " );
        double c = read.nextDouble();

        System.out.printf("\nSua equação ficou assim (%.1fx²) + (%.1fx) + (%.1f) = 0\n", a, b, c);

        double delta = (double) ((Math.pow(b, 2)) - (4 * a * c));

        if(delta > 0){
            System.out.printf("\nSeu delta é %.2f e possui duas raízes reais e distintas\n", delta);
        }   else if(delta == 0){
                System.out.printf("\nSeu delta é %.2f e possui uma raiz real\n", delta);
            }   else{
                    System.out.printf("\nSeu delta é %.2f e não possui raízes reais\n\n", delta);
                    return;
                }
            
        double root1 = (double) ((-b + Math.sqrt(delta)) / (2 * a));
        double root2 = (double) ((-b - Math.sqrt(delta)) / (2 * a));

        System.out.printf("\n1º Root = %.2f", root1);
        System.out.printf("\n2º Root = %.2f\n\n", root2);
    }
}
