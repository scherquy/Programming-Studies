package vetores;

import java.util.Arrays;

public class ValoresIguais {
    public static void main(String[] args) {
        
        int vetor[] = new int[10];

        Arrays.fill(vetor, 15);

        System.out.println();
        for(int valor: vetor){
            System.out.printf("%d ", valor);
        }

        System.out.println("\n");

    }
}
