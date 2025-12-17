**HERANÇA

Para herdar uma classe basta botar "extends" seguido do nome da classe que você quer herdar, por exemplo:

Se tiver uma classe Pessoa com "nome, cpf e endereço"

Aí você cria uma classe Funcionario que além desses atributos ele tem "salário"

Então ao invés de criar esses atributos dentro da classe Funcionario basta fazer um

public class Funcionario extends Pessoa {
	private double salário;
}

-----------------------------------------------------------------------

**SUPER HERANÇA

Se você tem um método imprime na classe Pessoa

`public void imprime() {`
	`System.out.println(this.nome);`
	`System.out.println(this.cpf);`
	`System.out.println(this.endereco);`
`}`

E aí na classe Funcionario você herdou a classe Pessoa e quer imprimir esses parâmetros + o salário que tem na classe Funcionario, você tem que escrever um método exatamente igual na classe que herdou pessoa e fazer super.nome do método que você quer utilizar, por exemplo

Método na classe Funcionario

`public void imprime() {`
	`super.imprime();`
	`System.out.println(this.salario);`
`}`

Dessa maneira ele vai imprimir o nome, cpf, endereço e o salário no main

-----------------------------------------------------------------------

**HERANÇA - CONSTRUTORES

Para um construtor ser herdado de uma classe para a outra basta fazer parecido com o que era feito com eles na mesma classe, só que ao invés de botar this(parâmetros) tem que fazer super(parâmetros) e o nome do construtor não precisa ser igual em todas as classes, cada construtor recebe o nome da sua classe