Nós utilizamos o **"this"** em um método quando vamos utilizar o atributo que está publico ou privado no objeto, mas utilizamos apenas o **"this"** quando tem algum argumento no método que vamos utilizar, por exemplo:

**CLASSE FUNCIONÁRIO

`package classeFuncionario;`

`public class Funcionario {`
	`private String nome;`
	`private int idade;`

	`public void setNome(String nome) {`
		`this.nome = nome;`

	`}`

	`public void setIdade(int idade){`
		`this.idade = idade;`
	`}`

	`public void imprime(){`
		`System.out.println(this.nome);`
		`System.out.println(this.idade);`
	`}`

`}`

Aqui fica explicada a questão do **"this"**, por exemplo, utilizamos nomes iguais aos privados nos parâmetros dos sets, então para saber que queremos utilizar os parâmetros lá de cima na classe funcionário utilizamos o  **"this"**, se utilizássemos só o "nome" sem o  **"this"** no início ele ia achar que estávamos usando a variável local que foi criada no parâmetro do set

**MAIN PRINCIPAL

`package classeTeste;`

`import classeFuncionario.Funcionario;`

`public class Main {`
	`public static void main(String[] args) {`

	`Funcionario func = new Funcionario();`

	`func.setNome("João");`
	`func.setIdade(15);`

	`func.imprime();`
	`}`
`}`

E o "set" serve para atribuir valores aos parâmetros privados que ficam lá na parte de cima, então sempre eu devo criar o método set para atribuir coisas aquelas variáveis que ficam privadas.

Quando queremos mostrar o objeto privado sozinho e sem utilizar algum método de imprimir podemos utilizar o get, ele vai retornar o que for atribuido a variável, por exemplo:

**CLASSE FUNCIOÁNRIO**
`package classeFuncionario;`

`public class Funcionario {`
	`private String nome;`
	`private int idade;`

	`public void setNome(String nome) {`
		`this.nome = nome;`
	`}`

	`public void setIdade(int idade){`
		`this.idade = idade;`
	`}`

	`public String getNome(){`
		`return this.nome;`
	`}`

	`public int getIdade(){`
		`return this.idade;`
	`}`
`}`

**MAIN PRINCIPAL**
`package classeTeste;`

`import classeFuncionario.Funcionario;`

`public class Main {`
	`public static void main(String[] args) {`
		`Funcionario func = new Funcionario();`

		`func.setNome("João");`
		`func.setIdade(15);`

		`System.out.println(func.getIdade() + "\n" + func.getNome());`
	`}`
`}`

O get não recebe nenhum parâmetro mas ele sempre tem que ser do mesmo tipo primitivo da variável que ele vai retornar

Utilizamos o SET e o GET só quando queremos dar acesso e utilizar os atributos privados (mas eu acho que da pra utilizar nos públicos também, só não sei se fica bonito e aceitável no código, mas com o tempo eu descubro)

Para inicializar as variáveis ao invés de usar "set" várias vezes caso sejam muitas variáveis basta criar um método que receba os parâmetros da classe e inicializar todos dentro desse método, por exemplo:

**Nesse exemplo eu usei o método "initialize" para inicializar os valores**
`package classeFuncionario;`

`public class Funcionario {`
	`private String nome;`
	`private int idade;`

	`public void initialize(String nome, int idade){`
		`this.nome = nome;`
		`this.idade = idade;`
	`}`

	`public String getNome(){`
	`return this.nome;`
	`}`

	`public int getIdade(){`
	`return this.idade;`
	`}`
`}`

**MAIN**
`package classeTeste;`

`import classeFuncionario.Funcionario;`

`public class Main {`

	`public static void main(String[] args) {`
		`Funcionario func = new Funcionario();`
		`func.initialize("João", 37);`
		
		`System.out.println(func.getIdade() + "\n" + func.getNome());`
	`}`
`}`

Para fazer uma sobrecarga de métodos basta chamar outro método dentro de um método utilizando "this.metodo()"

-----------------------------------------------------------------------

**GET E SET, QUANDO UTILIZAR

Se eu for alterar alguma coisa futuramente sem mostrar/printar essa coisa, eu uso só o set

Se eu for mostrar/printar alguma coisa futuramente sem alterar, apenas mostrar, eu uso só o get

Se eu for alterar e mostrar essa coisa futuramente eu uso o get e o set

Se eu não for alterar e nem mostrar nada futuramente eu não utilizo nenhum dos dois

Set = void (não retorna nada)
Get = String, int, double, etc (retorna algo)