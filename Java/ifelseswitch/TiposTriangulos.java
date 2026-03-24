package ifelseswitch;

import java.util.Scanner;

public class TiposTriangulos {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        System.out.printf("\nInforme o lado 'A': ");
        int a = read.nextInt();

        System.out.printf("\nInforme o lado 'B': ");
        int b = read.nextInt();

        System.out.printf("\nInforme o lado 'C': ");
        int c = read.nextInt();

        if((a + b > c) && (a + c > b) && (b + c > a)){
            System.out.printf("\nÉ um triângulo ");

            if(a == b && b==c){
                System.out.printf("EQUILÁTERO\n\n");
            }   else if((a == b && a != c) || (a == c && a != b) || (c == b && c != a)){
                    System.out.printf("ISÓSCELES\n\n");
                }   else{
                        System.out.printf("ESCALENO\n\n");
                    }
        }   else{
                System.out.printf("\nEssas medidas NÃO FORMAM um triângulo\n\n");
            }
    }
}
