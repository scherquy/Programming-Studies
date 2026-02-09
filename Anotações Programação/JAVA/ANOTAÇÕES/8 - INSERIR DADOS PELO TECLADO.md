Para inserir dados pelo teclado é um pouco mais complicado do que em C, temos que fazer 2 "import" antes de tudo

import java.util.Scanner; -> esse é para importar o leitor de dados pelo teclado

import java.util.Locale; -> esse é para o leitor aceitar os dados no padrão dos EUA

e então fazemos o seguinte

**MAIN**

`package classeTeste;`

`import java.util.Scanner;`
`import java.util.Locale;`

`public class Main {`
	`public static void main(String[] args) {`

	`Scanner leitura = new Scanner(System.in).useLocale(Locale.US);`
		
	`System.out.print("Informe seu nome: ");`
	`String nome = leitura.nextLine();`

	`System.out.print("Informe a sua idade: ");`
	`int idade = leitura.nextInt();`

	`System.out.print("Informe o seu sexo (M ou F): ");`
	`char sexo = leitura.next().charAt(0);`

	`System.out.print("Informe a sua altura: ");`
	`double altura = leitura.nextDouble();`

	`System.out.println("\n-----------------------------------------------\n");`

	`System.out.println("Nome: "+nome+"\n\nIdade: "+idade+"\n\nSexo: "+sexo+"\n\nAltura: "+altura);`
	`}`
`}`

Se tiver aqueles problemas de buffer igual tinha no C basta botar um
`leitura.nextLine();
para fazer a limpeza do buffer

no "char" eu usei só next porque o nextLine é para string, ai para o char nós colocamos o next().charAt(posição) no posição a gente escolhe de qual posição queremos pegar a letra