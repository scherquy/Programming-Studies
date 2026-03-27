package vetores;

import java.util.Arrays;

public class OrdenacaoEBusca {
    public static void main(String[] args) {
     
        int vetor[] = {1, 45, 5, 2, 34, 225, 8, 150};

        Arrays.sort(vetor);

        System.out.println();
        for(int valor: vetor){
            System.out.printf("%d ", valor);
        }

        System.out.println();
        for(int x=0; x<vetor.length; x++){
            int posicao = Arrays.binarySearch(vetor, vetor[x]);
            System.out.printf("\nO valor %d está na posição %d do vetor", vetor[x], posicao);
        }

        System.out.println("\n");
    }
}
