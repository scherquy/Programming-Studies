Na matéria de projeto digital vamos utilizar apenas o flip-flop tipo D

Como funciona o flip-flop em vhdl:

`entity FF is`
	`port(`
		`D : in std_logic;`
		`clock : in std_logic;`
		`Q : out std_logic`
	`);`
`end FF;`

`architecture behavior of FF is`
`begin`
	`process(E)`
	`begin`
		`if(clock = '1' and clock'event) then -- Sempre que o clock estiver ativado`
			`Q <= D; -- Q recebe D`
		`end if;`
	`end process;`
`end behavior;`

**OBS:** Quando o flip-flop tem APENAS o dado de entrada e o clock como pinos, o process só vai receber o clock

**OBS:** Sempre que fizer um flip-flop o "if" vai receber:
`"nome_do_clock" = "valor_que_ativa_o_clock" and "nome_do_clock"'event`

uar o 'event garante que o VHDL vai saber que não é um LETCH

-----------------------------------------------------------------------
**FLIP-FLOP COM PINO ASSÍNCRONO

Agora vamos ver um flip-flop que tem um pino "reset" que não depende do clock para ser ativado, ou seja, ele é um pino ASSÍNCRONO. Esse pino é ativado quando o reset está com o valor 0

`entity FF is`
	`port(`
		`clock : in std_logic;`
		`reset : in std_logic;`
		`D : in std_logic;`
		`Q : out std_logic`
	`);`
`end FF;`

`architecture behavior of FF is`
`begin`
	`process(clock, reset)`
	`begin`
		`if(reset = '0') then`
			`Q <= 0;`
		`elsif(clock = '1' and clock'event) then`
			`Q <= D;`
		`end fi;`
	`end process;`
`end behavior;`

**OBS:** O reset ASSÍNCRONO **DEVE** entrar na lista de sensibilidade do process

**OBS:** O teste do reset assíncrono sempre vem antes do teste de clock porque ele não depende do clock

-----------------------------------------------------------------------

**FLIP-FLOP COM PINO SÍNCRONO

Quando é um flip-flop síncrono, ele depende do clock para ser ativado, e o reset entra pelo mesmo lugar que o dado

Para decidir se o que vai entrar é o RESET ou o DADO utilizamos um mux

`entity FF is`
	`port(`
		`clock : in std_logic;`
		`reset : in std_logic;`
		`D : in std_logic;`
		`Q : out std_logic`
	`);`
`end FF;`

`architecture behavior of FF is`
`begin`
	`process(clock)`
	`begin`
		`if(clock = '1' and clock'event) then`
			`if(reset = '0') then`
				`Q <= '0';`
			`else`
				`Q <= D;`
		`end fi;`
	`end process;`
`end behavior;`

**OBS:** O reset precisa estar dentro do if do clock porque ele vem pelo pino de dado quando é SÍNCRONO

-----------------------------------------------------------------------

Se eu tiver flip-flops internos dentro de um circuito, os flip-flops internos SEMPRE devem ser declarados com signal