**CONSTRUTORES**

Construtores não retornam nada. Para criar um construtor é assim

"public ou private seguido do nome da classe() {}"

por exemplo:

`package classeFuncionario;`

`public class Funcionario {`
	`private String nome;`
	`private int idade;`

	  `public Funcionario(){`

	`}`
`}`

O construtor serve para inicializar os objetos, ao invés de fazer um método para inicializar basta fazer um construtor e se precisar da pra fazer sobrecarga de construtores igual a sobrecarga de inicialização dos métodos

Podemos utilizar o construtor assim:

**CLASSE**
`package classeFuncionario;`

`public class Funcionario {`
	`private String nome;`
	`private int idade;`

	`public Funcionario(String nome, int idade){` -> CONSTRUTOR
		`this.nome = nome;`
		`this.idade = idade;`
	`}`

	`public void imprime(){`
		`System.out.println(this.nome);`
		`System.out.println(this.idade);`
	`}`
`}`

**MAIN**
`package classeTeste;`

`import classeFuncionario.Funcionario;`

`public class Main {`
	`public static void main(String[] args) {`

		`Funcionario func = new Funcionario("Pedro", 78);`

		`func.imprime();`
	`}`
`}`

Para fazer uma sobrecarga de construtores basta fazer "this(parâmetros);" dentro do construtor que vai receber a sobrecarga, por exemplo:

**CLASSE**
`package classeFuncionario;`

`public class Funcionario {`
	`private String nome;`
	`private int idade;`
	`private int id;`

	`public Funcionario(String nome, int idade){`
		`this.nome = nome;`
		`this.idade = idade;`
	`}`

	`public Funcionario(String nome, int idade, int id){`
		`this(nome, idade);`
		`this.id = id;`
	`}`

	`public void imprime(){`
		`System.out.println(this.nome);`
		`System.out.println(this.idade);`
		`System.out.println(this.id);`
	`}`
`}`

**MAIN**
`package classeTeste;`

`import classeFuncionario.Funcionario;`

`public class Main {`
	`public static void main(String[] args) {`

		`Funcionario func = new Funcionario("Pedro", 78, 762);`

		`func.imprime();`
	`}`
`}`

Depois de fazer a sobrecarga basta adicionar os parâmetros no "new" da classe principal (main).

O "this()" só pode ser usado dentro de um construtor.

Se precisar fazer uma sobrecarga de construtor/chamar um construtor, OBRIGATÓRIAMENTE o "this()" deve ser a primeira linha, igual tá na classe ali, o "this()" fica na primeira linha e depois foi adicionado o this.id = id.

Para saber o que vai no construtor basta se perguntar "para eu iniciar essa classe, é obrigatório ter isso?" se a resposta for "sim" então esse item vai no construtor, se "não" esse item não vai no construtor. Por exemplo:

Para um clube de futebol jogar a série A ele precisa ter um estádio? Sim
(Então o estádio vai no construtor)

Para um clube de futebol jogar a série A ele precisa ter torcedores? Não
(Então torcedores não vai no construtor)