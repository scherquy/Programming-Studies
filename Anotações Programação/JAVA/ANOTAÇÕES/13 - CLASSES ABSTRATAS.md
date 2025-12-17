Uma classe abstrata serve de modelo para outras classes que vão estender ela, por exemplo

**Classe Funcionário

`package Dominio;`

`public abstract class Funcionario {`
	`protected String nome;`
	`protected double salario;`

	`public Funcionario (String nome, double salario) {`
		`this.nome = nome;`
		`this.salario = salario;`
	`}`

	`public String getNome() {`
		`return this.nome;`
	`}`

	`public double getSalario() {`
		`return this.salario;`
	`}`
`}`

**Classe Gerente** (estendeu a classe Funcionário que é abstrata)

`package Dominio;`

`public class Gerente extends Funcionario {`

	`public Gerente (String nome, double salario){`
		`super(nome, salario);`
	`}`

	`@Override`
	`public String toString() {`
		`return "\nGerente\n" + "\nNome: " + nome + "\nSalário: R$" + salario + "\n";`
	`}`
`}`

**OBS:** A classe que estende a classe abstrata tem que ter o toString para retornar algo


**Classe Main

`package Teste;`

`import Dominio.Funcionario;`
`import Dominio.Gerente;`

`public class main {`
	`public static void main(String[] args) {`

		`Gerente gerente = new Gerente("Pedro", 12500);`

		`System.out.println(gerente.toString());`
	`}`
`}`

Se for criar uma classe que se divide em várias outras subclasses que são uma extensão da classe, da para criar uma abstrata e apenas ir implementando ela nas outras subclasses

Uma classe abstrata pode ter métodos abstratos e concretos, mas classes concretas não podem ter métodos abstratos

Se você criar um método abstrato a implementação dele deve estar no subclasse onde você vai utilizar o método



