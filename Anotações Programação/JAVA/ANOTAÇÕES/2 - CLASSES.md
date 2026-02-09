
Classes são basicamente quando tu cria um objeto e dentro desse objeto tem várias informações relevantes, por exemplo

Classe PESSOA:
Nome
CPF
Sexo
Idade

Classe CARRO:
Cor
Placa
Modelo
Ano

Essa classe é criada separada do programa principal, por exemplo, aqui eu criei a classe estudante

	package classesDominio;

	public class Estudante {

		public String nome;
		public long cpf;
		public char sexo;
		public double peso, altura;
	}


E no programa principal eu utilizo a classe

	package classeTeste;
	
	import classesDominio.Estudante;

	public class EstudanteTeste {
		public static void main(String[] args){

			Estudante estud = new Estudante();

			estud.nome = "João";
			estud.cpf = 782694754;
			estud.sexo = 'M';
			estud.altura = 1.78;
			estud.peso = 70;

			System.out.println(estud.nome);
			System.out.println(estud.cpf);
			System.out.println(estud.sexo);
			System.out.println(estud.altura);
			System.out.println(estud.peso);
		}
	}