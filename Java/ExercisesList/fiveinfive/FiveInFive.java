/*64) Desenvolva um programa usando a estrutura “para” que mostre na tela a
seguinte contagem:
                    0 5 10 15 20 25 30 35 40 Acabou! */

package ExercisesList.fiveinfive;

public class FiveInFive {
    public static void main(String[] args) {

        System.out.println();

        for(int x=0; x<=40; x+=5){
            System.out.printf("%d ", x);
        }
        
        System.out.printf("Acabou!\n\n");
    }
}
