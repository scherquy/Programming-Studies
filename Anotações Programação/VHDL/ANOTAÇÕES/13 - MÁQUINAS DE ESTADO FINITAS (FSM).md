A FSM é composta de entradas, saídas, estados atuais, transições e próximo estado (TODAS AS DEFINIÇÕES SÃO FINITAS)

**PARTE DE CONTROLE =** Máquina de estado

**PARTE OPERATIVA =** O circuito que vamos ligar/desligar, por exemplo, um LED ligado a algum circuito

-----------------------------------------------------------------------

**CÓDIGO FSM**

`entity fsm is`
`port(`
	`clock : in std_logic;`
	`reset : in std_logic;`
	`button : in std_logic;`
	`led : out std_logic`
`);`
`end fsm;`

`architecture behavior of fsm is`
	`type state_name is (start, on); --nome dos estados`
	`signal state, next_state : state_name; --definição dos sinais de estado`
	`begin`
	
`process (clock, reset)`
`begin`
	`if (reset = ‘0’) then`
		`state <= start; --estado inicial via reset`
	`elsif (clock = ‘1’ and clock’event) then`
		`state <= next_state; --registrador(es) para armazenamento do estado`
	`end if;`
`end process;`

`--esse process define quando vamos de um estado para o outro`
`process (state, button) --nao tem clock, entao eh combinacional`
`begin`
	`case state is --caso seja`
		`when start => --o estado start`
			`if (button = ‘0’) then --se o botao for 0`
				`next_state <= start; --proximo estado recebe start`
			`else --se nao`
				`next_state <= on; --proximo estado recebe on`
			`end if;`
		`when on => --o estado on`
			`if (button = ‘0’) then --se o botao for 0`
				`next_state <= on; --proximo estado recebe on`
			`else - se nao`
				`next_state <= start; -- proximo estado recebe start`
			`end if;`
	`end case;`
`end process;`

`--process para as saidas (maquina de Moore - depende só do estado atual)`
`process (state)`
`begin`
	`case state is --case seja`
		`when start => -- o estado start`
			`led <= ‘0’; --led recebe 0`
		`when on => --o estado on`
			`led <= ‘1’; --led recebe 1`
	`end case;`
`end process;`

`--(maquina de  Mealy - depende do estado atual e da entrada)`
`process (state, button)`
`begin`
	`case state is --caso seja`
		`when start => --o estado start`
			`if (button = ‘0’) then --se o botao for 0`
				`led <= ‘0’; --led recebe 0`
			`else -- se nao`
				`led <= ‘1’; --led recebe 1`
			`end if;`
		`when on => -- o estado on`
			`if (button = ‘0’) then --se o botao for 0`
				`led <= ‘1’; --led recebe 1`
			`else --se não`
				`led <= ‘0’; --led recebe 0`
			`end if;`
	`end case;`
`end process;`

**OBS:** ESSE É A ÚNICA LÓGICA COMBINACIONAL QUE VAI UTILIZAR PROCESS

-----------------------------------------------------------------------

**OBS:** FSM tem flip-flop e o flip-flop tem reset assíncrono

Em VHDL podemos construir dados abstratos e vamos precisar deles para fazer uma FSM, eles são do tipo **type**

**state** no código acima é o flip-flop que foi definido no signal

É só seguir essa receita acima que vai dar certo para construir FSM

