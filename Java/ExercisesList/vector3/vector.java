/*73) Crie um programa que preencha automaticamente (usando lógica, não apenas
atribuindo diretamente) um vetor numérico com 10 posições, conforme abaixo:

                        9 8 7 6 5 4 3 2 1 0         */

package ExercisesList.vector3;

public class vector {
    public static void main(String[] args) {
        
        int vector[] = new int[10];

        System.out.println();

        for(int x=0; x<10; x++){
            vector[x] = 9 - x;

            System.out.printf("%d ", vector[x]);
        }

        System.out.printf("\n\n");
    }
}
