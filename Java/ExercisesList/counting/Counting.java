/*61) Crie um programa que mostre na tela a seguinte contagem, usando a estrutura
“faça enquanto”
                    0 3 6 9 12 15 18 21 24 27 30 Acabou! */

package ExercisesList.counting;

public class Counting {
    public static void main(String[] args) {
        
        int count = 0;

        System.err.println();
        do{
            System.out.printf("%d ", count);
            count += 3;
        }while(count <= 30);

        System.err.printf("Acabou!\n\n");
    }
}
