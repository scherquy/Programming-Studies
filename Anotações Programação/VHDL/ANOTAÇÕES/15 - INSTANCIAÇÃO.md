É quando queremos juntar várias partes no código.

Quando duas partes estão no mesmo nível hierárquico precisamos criar um bloco acima deles, chamamos essa entidade de **topo**, no **topo** vamos juntar as diferentes partes

Aqui no exemplo vamos juntar a FSM com o contador 3 bits:

`--Codigo da FSM`
`entity fsm is`
`port(`
	`clock : in std_logic;`
	`reset : in std_logic;`
	`button : in std_logic;`
	`enable : out std_logic`
`);`
`end fsm;`

`--Codigo do contador`
`entity contador is`
	`port(`
		`clock : in std_logic;`
		`reset : in std_logic;`
		`enable : in std_logic;`
		`result : out std_logic_vector (2 downto 0)`	
	`);`
`end contador;`

-----------------------------------------------------------------------

Agora vamos montar o TOPO, mas temos uma observação

**OBS:** O "enable" é um pino que sai da FSM e vai para o contador, ou seja, ele se comunica de um bloco para o outro. Sendo assim, ele é um componente INTERNO ao topo

Os outros pinos são EXTERNOS porque são entradas de usuário (button), resultado do contador (result) e por fim o clock e o reset

`--Codigo topo`
`entity top is`
`port(`
	`clock : in std_logic;`
	`reset : in std_logic;`
	`button : in std_logic;`
	`result : out std_logic_vector(2 downto 0)`
`);`
`end top;`

-----------------------------------------------------------------------

Agora precisamos fazer o seguinte

Repetir as entidades dos componentes que vão ser instanciados, só que como "component" antes do begin da arquitetura

`architecture behavior of top is`
`-- FSM`
`component fsm is`
	`port(`
		`clock : in std_logic;`
		`reset : in std_logic;`
		`button : in std_logic;`
		`enable : out std_logic`
	`);`
`end component;`

`-- Contador`
`component contador is`
	`port(`
		`clock : in std_logic;`
		`reset : in std_logic;`
		`enable : in std_logic;`
		`result : out std_logic_vector(2 downto 0)`
	`);`
`end component;`

`signal enable_sg : std_logic;`

**OBS:** Os nomes das entidades tem que ser os mesmos dos componentes

**OBS:** Pinos internos ao bloco Topo (como no nosso exemplo o "enable" devem ser declarados como "signal" antes do begin

-----------------------------------------------------------------------

Logo em seguida temos que mapear os pinos, isso é feito dentro da parte de arquitetura após o begin

`begin`
	`--start mapping`
	`fsm_inst: fsm`
		`port map (`
			`clock => clock,`
			`reset => reset,`
			`button => button,`
			`enable => enable_sg`
		`);`
		
	`contador_inst: contador`
		`port map(`
			`clock => clock,`
			`reset => reset,`
			`enable => enable_sg,`
			`result => result`
		`);`
`end behavior;`

**OBS:** no lado esquerdo são os nomes dos **PINOS**, no lado direito são os nomes dos **SIGNALS**

