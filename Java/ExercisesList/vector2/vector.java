/*72) Crie um programa que preencha automaticamente (usando lógica, não apenas
atribuindo diretamente) um vetor numérico com 10 posições, conforme abaixo:

                5 10 15 20 25 30 35 40 45 50 */

package ExercisesList.vector2;

public class vector {
    public static void main(String[] args) {
        
        int vector[] = new int[10];

        System.out.println();

        for(int x=0; x<10; x++){

            if(x == 0){
                vector[x] = 5;
            }   else{
                    vector[x] = vector[x-1] + 5;
                }

            System.out.printf("%d ", vector[x]);
        }

        System.out.printf("\n\n");
    }
}
