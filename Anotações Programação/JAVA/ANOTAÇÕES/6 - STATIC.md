Quando nós utilizamos métodos estáticos (static) se quisermos acessar eles e estiverem privados basta fazer um set ou get mas ao invés de usar "this." nós utilizamos o "nome da classe." antes de acessar, por exemplo:

se a classe se chama Aluno e os dias de aula forem "static" para acessar os dias de aula nós utilizamos 

Aluno.diasDeAula = diasDeAula;

para printar também, se quiser printar o que tá no "static" basta botar dentro do System.out.println(Aluno.diasDeAula);

Métodos estáticos SÓ podem acessar variáveis estáticas, mas métodos não estáticos podem acessar variáveis estáticas e não estáticas