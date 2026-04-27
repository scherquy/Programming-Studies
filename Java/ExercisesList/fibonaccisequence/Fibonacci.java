/*70) [DESAFIO] Faça um programa que mostre os 10 primeiros elementos da Sequência
de Fibonacci:
                        1 1 2 3 5 8 13 21... */

package ExercisesList.fibonaccisequence;

public class Fibonacci {
    public static void main(String[] args) {
        
        int result = 0, previous = 0, actual = 1;

        System.out.println();

        for(int x=0; x<10; x++){

            if(x == 0 || x == 1){
                result = x;
            }   else{
                    result = previous + actual;
                }
            
            System.out.printf("%d ", result);

            previous = actual;
            actual = result;
        }

        System.out.printf("\n\n");
    }
}
