**CONSTANTES - Tipos Primitivos

Para definir uma constante no Java nós botamos "final" antes do tipo dela e usamos o static, nos tipos PRIMITIVOS, por exemplo

public class Gorjeta {
	private static final double TAXA = 0.75;
}

O "final" garante que essa variável vai ser uma constante e você precisa obrigatoriamente dar um valor a ela e ela nunca vai poder ser mudada no meio do código porque é uma constante e elas podem ser públicas, privadas, protected, etc;

Constantes tem uma convenção em Java, ela deve ser toda em MAIÚSCULA e se forem duas palavras elas devem ser separadas por _

public class Carro {
	 private String nome;
	 public static final double VELOCIDADE_MÁXIMA = 200;
}

E lembrando que para acessar métodos "static" no Main ou em outras classes temos que chamar o próprio nome da classe, por exemplo, na classe Carro nós iríamos chamar

Carro.VELOCIDADE_LIMITE;

e na classe Gorjeta

Gorjeta.TAXA;

No caso podemos colocar essas chamadas dentro de prints, for, whiles, outras variáveis e por aí vai.

-----------------------------------------------------------------------

**CONSTANTES - Classes e Métodos

Quando você tem uma classe e NÃO quer que ela seja estendida então você bota o "final" nela, por exemplo

public final class Carro {
	 private String nome, modelo;
	 private double valor;
}

Esse "final" diz que a classe não pode ser herdada/estendida por outras classes

Já nos métodos, se botar um "final" ele não vai poder ser sobrecarregado em outras classes e etc, ele vai seguir o mesmo padrão em todas as classes, por exemplo

public final void imprimeCarro() {
	System.out.println(this.nome);
	System.out.println(this.valor);
}

Se eu criar esse método em outra classe eu não posso sobrecarregar ele para imprimir um modelo ou placa de outro carro, ele vai seguir imprimindo apenas o nome e o valor do carro em todos os lugares porque está com "final" e é constante

E se você deixar a classe constante não tem sentido deixar os métodos constantes porque se a classe é constante automaticamente os métodos vão ser também, só deixe os métodos constantes caso a classe não seja constante
