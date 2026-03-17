package nota;

import java.util.Scanner;

public class Nota {
    public static void main(String[] args) {
	
	Scanner dados = new Scanner(System.in);
	
	System.out.printf("\nInforme o nome do(a) aluno(a): ");
	String nome = dados.nextLine();
	
	System.out.printf("\nInforme a nota de %s: ", nome);
	float nota = dados.nextFloat();

    dados.nextLine();
	
	System.out.printf("\nA nota de %s é %.2f\n\n", nome, nota);
    }
}
