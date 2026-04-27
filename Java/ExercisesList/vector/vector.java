/*71) Faça um programa que preencha automaticamente um vetor numérico com 8
posições, conforme abaixo:
                        
                    999 999 999 999 999 999 999 999         */

package ExercisesList.vector;

public class vector {
    public static void main(String[] args) {
        
        int vector[] = new int[8];

        System.out.println();

        for(int x=0; x<8; x++){
            vector[x] = 999;

            System.out.printf("%d ", vector[x]);
        }

        System.out.printf("\n\n");
    }
}
