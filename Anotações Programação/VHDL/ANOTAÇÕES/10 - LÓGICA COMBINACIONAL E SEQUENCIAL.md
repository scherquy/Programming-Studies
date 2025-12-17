Lógica combinacional é por exemplo, se tu mudar algo na entrada, a saída vai mudar.

Quando for fazer uma lógica combinacional com if/else/switch e etc a última comparação não deve ter nada, assim não da problema no vhdl.

`entity mux is`
	`port(`
		`A : in std_logic; -- entrada A`
		`B : in std_logic; -- entrada B`
		`C : in std_logic; -- entrada C`
		`D : in std_logic; -- entrada D`
		`S : in std_logic_vector (1 downto 0); -- seletor`
		`M : out std_logic -- saida mux`	
	`);`
`end mux;`
`architecture behavior of mux is`
	`begin`
		`M <= A when S = "00" esle -- M recebe o valor de A se S for 00`
			 `B when S = "01" else -- M recebe o valor de B se S for 01`
			 `C when S = "10" else -- M recebe o valor de C se S for 10`
			 `D; -- M recebe o valor de D se S for 11 ou outros valores`
`end behavior;`

-----------------------------------------------------------------------
**PROCESS

Para fazer lógica combinacional podemos utilizar "process" e ao utilizar "process" precisamos de uma lista de sensibilidade onde **TODAS** as entradas e sinais de controle da lógica combinacional precisam ser incluídas

Essas entradas e sinais são **TUDO** que estiver no lado direito da atribuição/lógica ou sendo utilizados em if, case, etc

Por exemplo:

`architecture behavior of mux is`
`begin`
	`process (in1, in2)`
	`begin`
		`out1 <= (not(in1 or in2)) xor in2;`
	`end process;`
`end behavior;`

**OBS:** A única lógica combinacional que é recomendada fazer com process é a máquina de estados

Dentro do process não da para usar "when" sem case, tem que usar case

`architecture behavior of mux is`
`begin`
	`process (A, B, C, D, S)`
	`begin`
		`case S is`
			`when "00" => M <= A;`
			`when "01" => M <= B;`
			`when "10" => M <= C;`
			`when others => M <= D;`
		`end case;`
	`end process;`
`end behavior;`

**OBS:** o process só vai ser utilizado para fazer lógica SEQUENCIAL

-----------------------------------------------------------------------

**DIFERENÇA ENTRE LÓGICA COMBINACIONAL E SEQUENCIAL

**COMBINACIONAL**

- **Sem memória** - a saída depende apenas das entradas
- **Sem elementos de tempo** - não usa clock
- Portas, MUX, Decodificadores

**SEQUENCIAL**

- **Com memória** - a saída depende das entradas **E do estado anterior**
- **Usa elementos de tempo** - flip-flops, registradores, FSM
- **Sincronizada por clock**
- **Tem "memória" do passado**

-----------------------------------------------------------------------

- **Combinacional**: Cálculos, roteamento, lógica booleana

- **Sequencial**: Memória, contadores, máquinas de estado, pipelines

**Resumo:** Combinacional = "o que entra agora, sai agora" / Sequencial = "lembra do passado"

-----------------------------------------------------------------------

Existem também as **lógicas mistas** que misturam as duas lógicas anteriores misturadas e nós utilizamos somente process