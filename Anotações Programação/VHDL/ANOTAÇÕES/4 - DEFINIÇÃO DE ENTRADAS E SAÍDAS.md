Para definir as entradas e saídas utilizamos "entity"

`entity "nome_qualquer_da_entity" is`
	`port(`
			`entrada1 : in std_logic;`
			`entrada2 : in std_logic;`
			`saida : out std_logic );`
`end "nome_qualquer_da_entity";

A definição das entradas tem "in" e das saídas tem "out"

Se botar só o std_logic no final sem um "vector" então é 1 bit, se usar "vector" da pra definir quantos bits vão ter