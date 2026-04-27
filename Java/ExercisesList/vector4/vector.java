/*74) Crie um programa que preencha automaticamente (usando lógica, não apenas
atribuindo diretamente) um vetor numérico com 10 posições, conforme abaixo:
                         
                            5 3 5 3 5 3 5 3 5 3 */

package ExercisesList.vector4;

public class vector {
    public static void main(String[] args) {
        
        int vector[] = new int[10];

        System.out.println();

        for(int x=0; x<10; x++){

            if((x%2) == 0){
                vector[x] = 5;
            }   else if((x%2) == 1){
                    vector[x] = 3;
                }

            System.out.printf("%d ", vector[x]);
        }

        System.out.printf("\n\n");
    }
}
