package vetores;

import java.util.Arrays;

public class TestForIt {
    public static void main(String[] args) {
     
        int vetor[] = {1, 45, 5, 2, 34, 225, 8, 150};

        Arrays.sort(vetor);

        System.out.println();
        for(int valor: vetor){
            System.out.printf("%d ", valor);
        }
        System.out.println("\n");
    }
}
