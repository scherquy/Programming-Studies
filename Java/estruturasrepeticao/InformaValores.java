package estruturasrepeticao;

import java.util.Scanner;

public class InformaValores {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        int value = (int) 0, totalValues = (int) 0, evenNumbers = (int) 0, oddNumbers = (int) 0, overOneHundred = (int) 0, cont = (int) 0, sumValues = (int) 0;
        float averageGradeValues = (float) 0;
        char yesOrNo;

        do{
            System.out.printf("\nInforme um valor: ");
            value = read.nextInt();

            System.out.printf("\nQuer informar mais um valor (S/N)? ");
            yesOrNo = read.next().charAt(0);

            totalValues++;

            if(value%2 == 0){
                evenNumbers++;
            }   else if(value%2 == 1){
                    oddNumbers++;
                }
            
            if(value > 100){
                overOneHundred++;
            }

            sumValues += value;

            cont++;
        } while(yesOrNo == 'S' || yesOrNo == 's');

        averageGradeValues = (float) (sumValues/cont);

        System.out.printf("\nTotal de Valores: %d", totalValues);
        System.out.printf("\nTotal de Pares: %d", evenNumbers);
        System.out.printf("\nTotal de Ímpares: %d", oddNumbers);
        System.out.printf("\nTotal de Valores Acima de Cem: %d", overOneHundred);
        System.out.printf("\nMédia dos Valores: %.2f\n\n", averageGradeValues);
    }
}
