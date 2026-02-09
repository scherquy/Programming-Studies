**ASSOCIAÇÃO**

Fazendo arrays com objetos.

**CLASSE CARRO**

`package classeFuncionario;`

`public class Car {`
	`private String nome;`

	`public Car(String nome) {`
		`this.nome = nome;`
	`}`

	`public void imprime(){`
		`System.out.println(this.nome);`
	`}`
`}`

**MAIN**

`package classeTeste;`

`import classeFuncionario.Car;`

`public class Main {`
	`public static void main(String[] args) {`

		`Car car1 = new Car("Lancer");`
		`Car car2 = new Car("Golf GTI");`
		`Car car3 = new Car("Fusca");`
		`Car car4 = new Car("Bel Air");`

		`Car[] vehicles = {car1, car2, car3, car4};`

		`for(int x=0; x<vehicles.length; x++) {`
			`vehicles[x].imprime();`
		`}`
	`}`
`}`

Criei 4 objetos (car1, car2, car3 e car4) e logo em seguida criei um array para guardar os nomes dos carros, depois disso eu imprimi os nomes dos carros que estavam no array

Basicamente associação é botar vários objetos dentro de um Array.

Aqui outro exemplo de associação, dessa vez criei 2 classes, uma "Professor" e outra "Escola" que recebe a classe "Professor" em um vetor

**CLASSE PROFESSOR**

`package classeFuncionario;`

`public class Professor {`
	`private String nomeProfessor;`

	`public Professor(String nomeProfessor){`
		`this.nomeProfessor = nomeProfessor;`
	`}`

	`public void setnomeProfessor(String nomeProfessor){`
		`this.nomeProfessor = nomeProfessor;`
	`}`

	`public String getnomeProfessor() {`
		`return nomeProfessor;`
	`}`
`}`

**CLASSE ESCOLA**

`package classeFuncionario;`

`public class Escola {`
	`private String nomeEscola;`
	`private Professor[] professores;`

	`public void imprime(){`
		`System.out.println("Escola "+this.nomeEscola+"\n");`

		`if(this.professores == null) return;`

		`else{`
			`for(int x=0; x<this.professores.length; x++) {`
				`System.out.println("Professor(a) "+this.professores[x].getnomeProfessor());`
			`}`
		`}`
	`}`

  
	`public Escola(String nomeEscola) {`
		`this.nomeEscola = nomeEscola;`
	`}`

	`public Escola(String nomeEscola, Professor[] professores) {`
		`this(nomeEscola);`
		`this.professores = professores;`
	`}`

	`public void setnomeEscola(String nomeEscola) {`
		`this.nomeEscola = nomeEscola;`
	`}`

	`public String getnomeEscola() {`
		`return this.nomeEscola;`
	`}`

	`public void setprofessores(Professor[] professores) {`
		`this.professores = professores;`
	`}`

	`public Professor[] professores() {`
		`return this.professores;`
	`}`
`}`

**MAIN**

`package classeTeste;`

`import classeFuncionario.Escola;`
`import classeFuncionario.Professor;`

`public class Main {`
	`public static void main(String[] args) {`

		`Professor prof1 = new Professor("Paulo");`
		`Professor prof2 = new Professor("Fernando");`
		`Professor prof3 = new Professor("Julio");`
		`Professor prof4 = new Professor("Serjão");`

		`Professor[] professores = {prof1, prof2, prof3, prof4};`

		`Escola escola = new Escola ("Frei Plácido", professores);`

		`escola.imprime();`
	`}`
`}`
