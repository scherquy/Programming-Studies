/*65) Desenvolva um programa usando a estrutura “para” que mostre na tela a
seguinte contagem:
                    100 90 80 70 60 50 40 30 20 10 0 Acabou! */

package ExercisesList.teninten;

public class TenInTen {
    public static void main(String[] args) {
        
        System.out.println();

        for(int x=100; x>=0; x-=10){
            System.out.printf("%d ", x);
        }

        System.out.printf("Acabou!\n\n");
    }
}
