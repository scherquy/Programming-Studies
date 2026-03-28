package vetores;

import java.util.Scanner;
import java.util.Arrays;

public class OpcoesVetor {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int vector[] = new int[10];
        
        byte op;
        int addValue, vectorPosition;

        do{

            int quitCondition=1;

            System.out.printf("\n ___________    ___________ ");
            System.out.printf("\n|___________MENU___________|");
            System.out.printf("\n|                          |");
            System.out.printf("\n| 1 - ADD VALUE            |");
            System.out.printf("\n| 2 - REMOVE VALUE         |");
            System.out.printf("\n| 3 - PUT VECTOR IN ORDER  |");
            System.out.printf("\n| 0 - QUIT                 |");
            System.out.printf("\n|__________________________|\n\n");

            System.out.printf("Choice a option: ");
            op = read.nextByte();

            switch (op) {
                case 0:
                    System.out.printf("\n\nVOCÊ SAIU DO MENU\n\n");
                    break;
                case 1:
                    System.out.printf("\n\nInforme o valor que você quer adicionar no vetor: ");
                    addValue = read.nextInt();

                    do{
                        System.out.printf("\nEm que posição do vetor (0 a %d) você quer adicionar o valor %d: ", vector.length-1, addValue);
                        vectorPosition = read.nextInt();

                        if(vectorPosition >= 0 && vectorPosition < 10){
                            quitCondition = 0;
                        }
                    } while(quitCondition != 0);

                    for(int x=0; x<vector.length; x++){
                        if(x == vectorPosition){
                            vector[x] = addValue;
                        }
                    }

                    System.out.println();
                    for(int valor: vector){
                        System.out.printf("%d ", valor);
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.println();
                    do{
                        System.out.printf("\nInforme a posição (0 a %d) do valor que você quer remover do vetor: ", vector.length-1);
                        vectorPosition = read.nextInt();

                        if(vectorPosition >= 0 && vectorPosition < 10){
                            quitCondition = 0;
                        }
                    } while(quitCondition != 0);

                    for(int x=0; x<vector.length; x++){
                        if(x == vectorPosition){
                            vector[x] = 0;
                        }
                    }

                    System.out.println();
                    for(int valor: vector){
                        System.out.printf("%d ", valor);
                    }
                    System.out.println();
                    break;

                case 3:
                    Arrays.sort(vector);

                    System.out.println();

                    for(int valor: vector){
                        System.out.printf("%d ", valor);
                    }

                    System.out.println();
                    break;
            
                default:
                    System.out.printf("\n\nVALOR INVÁLIDO\n");
                    break;
            }
        } while(op != 0);
    }
}
