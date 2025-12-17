Enumerações são um tipo de classe, então definimos ela separadamente e dentro dela colocamos as opções que fazem parte da enumeração, por exemplo

`public enum Produtos {`
	`Arroz,`
	`Feijão,`
	`Batata,`
	`Refrigerante`
`}`

Então para utilizar essa classe em outras classes nós fazemos assim

`public class Compras {`
	`protected/public/private Produtos produtos;`
`}`

Para passar ele como parâmetro no main nós utilizamos 

Compras compra1 = new Compras (Produtos.Arroz);
Compras compra2 = new Compras (Produtos.Feijão);
etc...

Da para trabalhar com valores também igual era utilizado em C, aí nós devemos fazer o seguinte na classe enumeração

`public enum Produtos {`
	`Arroz(1),`
	`Feijão(2),`
	`Batata(3),`
	`Refrigerante(4);`

	`public final int valor;`

	`public Produtos(int valor) {`
		`this.valor = valor;`
	`}`
`}`

Dessa maneira as enums recebem valores e fica mais intuitivo de trabalhar igual era em C

Até da pra usar o int valor sem o final, mas aí tem que criar um get para retornar o valor e botar "private" int valor

Podemos criar diferentes variáveis dentro dos tipos das enums, por exemplo:

`public enum Produtos {`
	`Arroz(1, "Cereal"),`
	`Feijão(2, "Leguminosa"),`
	`Batata(3, "Hortaliça"),`
	`Refrigerante(4, "Câncer");`

	`public final int valor;`
	public final String tipoProduto;

	`private Produtos(int valor, String tipoProduto) {`
		`this.valor = valor;`
		this.tipoProduto = tipoProduto;
	`}`
`}`

Os tipos sempre tem que vir abaixo das enums definidas e os tipos podem ser públicos ou privados. Se não forem constantes ("final") temos que utilizar os gets para retornar e botar os tipos como privados

-----------------------------------------------------------------------

**ENUMERAÇÕES - Sobrescrita de Métodos

Para fazer coisas tipo, descontos e etc sem precisar fazendo muitos if ou else podemos utilizar um método nas classes, por exemplo, nas enums

`public enum TipoPagamento {`
	`DEBITO {`
		`@Override`	
		`public abstract double calcularDesconto (double valor){`
			`return valor * 0.1`;
		`}`
	`},`
	`CREDITO {`
		`@Override`	
		`public abstract double calcularDesconto (double valor){`
			`return valor * 0.05`;
		`}`
	`};`

	public abstract double calcularDesconto (double valor);
	
`}`

Basicamente se a pessoa escolher o débito ela vai ter um desconto de 10% e se escolher o crédito vai ter um desconto de 5% e isso ajuda a não ter que fazer vários if ou else dentro do código principal, embaixo tem uma classe abstrata, utilizamos ela quando não queremos retornar nada por ela, aí botamos abstract e retornamos ela dentro de uma enum ou outro parâmetro que tenha sido definido no topo de alguma classe
