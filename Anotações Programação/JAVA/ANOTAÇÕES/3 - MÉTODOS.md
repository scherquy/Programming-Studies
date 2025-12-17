**MÉTODOS

Eles ficam dentro de classes e podem ou não retornar algo, se não retornar nada nós utilizamos apenas "public void", os métodos são tipo as funções em C. Podemos criar vários métodos dentro de uma classe. Por exemplo:

Aqui é um exemplo de uma calculadora utilizando métodos que não vão retornar nada

Criamos a classe calculadora e o método é criado dentro da classe

	package classesDominio;
	
	public class Calculadora {
	
		public void somaValores() {
			System.out.println(75 + 25);
			return;
		}
		
		public void subtraiValores(){
			System.out.println(83 - 14);
			return;
		}
	}

Então na parte principal nós fazemos assim para utilizar o método:

	package classeTeste;
	
	import classesDominio.Calculadora;
	
	public class testeCalculadora {
	
		public static void main(String[] args) {
	
			Calculadora calc = new Calculadora();
	
			calc.somaValores();
			calc.subtraiValores();
		}
	}

Se quiser pode passar parâmetros por meio desses métodos, basta fazer igual era nas funções em C e botar os parâmetros entre os (). Por exemplo:

Essa é a classe com os métodos

	package classesDominio;
		
	public class Calculadora {	
		public void somaValores(int val1, int val2) {
	
			System.out.println(val1 + val2);
			return;
		}
	
		public void subtraiValores(int val1, int val2){
			System.out.println(val1 - val2);
			return;
		}	
	}

Esse é o principal (main)

	package classeTeste;
	
	import classesDominio.Calculadora;
		
	public class testeCalculadora {
		public static void main(String[] args) {	
			
			Calculadora calc = new Calculadora();
	
			calc.somaValores(10, 15);
			calc.subtraiValores(15, 5);
		}
	}

Dá para fazer métodos retornando algo também, por exemplo:

Essa é a parte dos métodos

	package classesDominio;
	
	public class Calculadora {	
	
		public int somaValores(int val1, int val2) {
			return val1 + val2;
		}
	
		public double divideValores(double val1, double val2){	
			return val1 / val2;
		}
	}

Essa é a parte principal (main)

	package classeTeste;
	
	import classesDominio.Calculadora;
		
	public class testeCalculadora {
		public static void main(String[] args) {
	
			Calculadora calc = new Calculadora();
	
			System.out.println(calc.somaValores(10, 5));
			System.out.println(calc.divideValores(15, 5));
		}
	}

Se for necessário esses métodos podem retornar 0, aí é só botar "return 0;" no final

-----------------------------------------------------------------------

**PASSAGEM DE REFERÊNCIA ENTRE OS MÉTODOS

Os famosos ponteiros em C, para passar o valor original e não uma cópia basta seguir os exemplos de códigos abaixo, basicamente você tem que adicionar o "Nome nome" entre () do método que vai receber, por exemplo

Essa é a classe Carro

	package classesDominio;
	
	public class Carro {	
		public String nome;	
		public double valor;	
		public int ano;
	}

Essa é a classe para imprimir os carros com o método de impressão

	package classesDominio;
	
	public class ImprimirCarro {
	
		public void imprimir(Carro car) {	
			//car.nome = "Lancer";
			System.out.println(car.nome + "\nAno: " + car.ano + "\nR$ " + car.valor);
		}
	}

Essa é a classe principal (main)

	package classeTeste;
	
	import classesDominio.*;
	
	public class Teste {	
		public static void main(String[] args) {
		
			Carro car = new Carro();
			ImprimirCarro imprimir = new ImprimirCarro();
	
			car.nome = "Palio";
			car.ano = 2010;
			car.valor = 15500.75;
	
			imprimir.imprimir(car);
		}
	
	}

Quando passamos **public void imprimir(Carro car)** como parâmetro estamos passando a variável original e se alterarmos ela dentro do método ela vai ser alterada no programa principal também.
