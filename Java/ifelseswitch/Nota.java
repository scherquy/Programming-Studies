package ifelseswitch;

import java.util.Scanner;

public class Nota {
    public static void main(String[] args) {
	
	Scanner read = new Scanner(System.in);
	
	System.out.printf("\nInforme o nome do(a) aluno(a): ");
	String name = read.nextLine();
	
	System.out.printf("\nInforme a 1º nota de %s: ", name);
	float grade1 = read.nextFloat();

	System.out.printf("\nInforme a 2º nota de %s: ", name);
	float grade2 = read.nextFloat();

    read.nextLine();

	float averageGrade = (float)((grade1 + grade2) / 2);
	
	if(averageGrade >= 9){
	System.out.printf("\nA média final de %s é %.2f. Parabéns\n\n", name, averageGrade);
	}	else{
			System.out.printf("\nA média final de %s é %.2f\n\n", name, averageGrade);
		}
    }
}
