/*57) Desenvolva um aplicativo que leia o salário e o sexo de vários funcionários.
No final, mostre o total de salários pagos aos homens e o total pago às
mulheres. O programa vai perguntar ao usuário se ele quer continuar ou não
sempre que ler os dados de um funcionário. */

package ExercisesList.readdata;

import java.util.Scanner;

public class ReadData {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        double salary = 0, totalSalaryMan = 0, totalSalaryWoman = 0;
        String gender = "", option = "";

        do{
            System.out.printf("\nInforme o salário do(a) funcionário(a): R$ ");
            salary = read.nextDouble();

            read.nextLine();

            System.out.printf("Informe o sexo do(a) funcionário(a) (Homem ou Mulher): ");
            gender = read.nextLine();

            if(gender.charAt(0) == 'H' || gender.charAt(0) == 'h'){
                totalSalaryMan += salary;
            }   else if(gender.charAt(0) == 'M' || gender.charAt(0) == 'm'){
                    totalSalaryWoman += salary;
                }

            System.out.printf("\nDeseja continuar informando dados (Sim ou Não)? ");
            option = read.nextLine();
        }while(option.charAt(0) != 'N' && option.charAt(0) != 'n');

        System.out.printf("\nTotal de salários pagos para os homens: R$ %.2f", totalSalaryMan);
        System.out.printf("\nTotal de salários pagos para as mulheres: R$ %.2f\n\n", totalSalaryWoman);
    }
}
