/*75) Crie um programa que preencha automaticamente (usando lógica, não apenas
atribuindo diretamente) um vetor numérico com 16 posições com os primeiros
elementos da sequência de Fibonacci:
            
                1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987*/

package ExercisesList.fibonaccivector;

public class FibonacciVector {
    public static void main(String[] args) {
        
        int vector[] = new int[16], previous = 0, actual = 1;

        System.out.println();

        for(int x=0; x<16; x++){

            if(x==0 || x==1){
                vector[x] = 1;
            }   else{
                    vector[x] = previous + actual;
                }
            
            previous = actual;
            actual = vector[x];

            System.out.printf("%d ", vector[x]);
        }

        System.out.printf("\n\n");
    }
}
