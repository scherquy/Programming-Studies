Serve para simular as lógicas feitas em VHDL. É um outro código VHDL que vai ficar mudando os valores do circuito para testar e ver se está funcionando pela forma de ondas

**OBS:** O testbench NÃO PRECISA SER SINTETIZÁVEL, ele só vai existir para teste

O testbench só enxerga as entradas e as saídas do topo, nada mais

No testbench só as entradas devem ser criadas porque só elas que precisam ser estimuladas

**OBS:** As bibliotecas também DEVEM estar no testbench

Aqui vamos criar um testbench para o circuito que criamos na parte de instanciação

**OBS:** A entidade do testbench é VAZIA

`entity tb_top is`

`end tb_top;`

`architecture behavior of tb_top is`
`component top is`
	`port(`
		`clock : in std_logic;`
		`reset : in std_logic;`
		`button : in std_logic;`
		`result : out std_logic_vector(2 downto 0)`
	`);`
`end component;`

`signal clock_sg : std_logic := ‘0’;` ->os pinos de entrada já recebem valores aqui
`signal reset_sg : std_logic := ‘0’;`
`signal button_sg : std_logic := ‘0’;`
`signal result_sg : std_logic_vector (2 downto 0);` ->os de saída não recebem valores

`begin`
`inst_top: top` ->foi feito o mapeamento aqui, para ele saber que é do topo
	`port map (`
		`clock => clock_sg,`
		`reset => reset_sg,`
		`button => button_sg,`
		`result => result_sg`
	`);`

`--Agora vamos criar os estímulos para cada entrada`
`clock_sg <= not clock_sg after 20 ns; --geracao do clock, a cada 20ns ele liga e                                         desliga`

	`process`
	`begin`
		`wait for 10 ns; --espera 10ns`
			`reset_sg <= ‘1’; -- reset vai para 1, ou seja, eh desligado`
		`wait for 40 ns; --espera 40ns`
			`button_sg <= ‘1’; --button vai para 1, ou seja, eh ativado`
		`wait for 20 ns; --espera 20ns`
			`button _sg<= ‘0’; -- button vai para 0, ou seja, eh desativado`
		`wait for 100 ns; --espera 100ns`
			`button _sg<= ‘1’; -- button vai para 1, ou seja, eh ativado`
		`wait for 20 ns; --espera 20ns`
			`button _sg<= ‘0’; -- button vai para 0, ou seja, eh desativado`
		`wait;`
	`end process;`
`end behavior;`