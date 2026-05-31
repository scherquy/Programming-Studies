/*93) Faça um programa que tenha um procedimento chamado Contador() que recebe
três valores como parâmetro: o início, o fim e o incremento de uma contagem. O
programa principal deve solicitar a digitação desses valores e passá-los ao
procedimento, que vai mostrar a contagem na tela.
Ex: Para os valores de início (4), fim (20) e incremento(3) teremos
Contador(4, 20, 3) vai mostrar na tela 4 >> 7 >> 10 >> 13 >> 16 >> 19 >> FIM */

package ExercisesList.incremento;

import java.util.Scanner;

public class Incremento {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int values[] = new int[3];

        System.out.printf("\nInforme 3 valores:\n\n1º valor -> INÍCIO\n2º valor -> FIM\n3º valor -> INCREMENTO\n");

        for(int x=0; x<values.length; x++){
            System.out.printf("\nInforme o %dº valor: ", x+1);
            values[x] = read.nextInt();
        }

        Counter(values);
    }

    static void Counter(int values[]){
        for(int x=values[0]; x <= values[1]; x += values[2]){
            System.out.printf("%d >> ", x);
        }
        System.out.printf("FIM\n\n");
    }
}
