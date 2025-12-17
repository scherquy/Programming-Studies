Utilizando o contador de 3 bits como exemplo, ao invés de utilizar como saída um LED, vou utilizar "enable"

então o código do contador de 3 bits fica

`entity contador is`
	`port(`
		`clock : in std_logic;`
		`reset : in std_logic;`
		`enable : in std_logic;`
		`result : out std_logic_vector (2 downto 0)`	
	`);`
`end contador;`

`architecture behavior of contador is`
`begin`
	`process(clock, reset)`
	`begin`
		`if(reset = '0') then`
			`result <= (others => '0'); -> número de "0" fica do tamanho do vetor result`
		`elsif(clock = '1' and clock'event) then`
			`if(enable = 1) then`
				`result <= result + 1;`
		`end if;`
	`end process;`
`end behavior;` 

**OBS:** a única diferença é que o incremento só vai acontecer se o enable estiver ativado e na lista de sensibilidade o enable não vai porque ele é "subordinado" ao clock

**OBS:** o **enable** diz quando os flip-flops devem ser atualizados