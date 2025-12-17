`entity contador is`
	`port(`
		`clock : in std_logic;`
		`reset : in std_logic;`
		`result : out std_logic_vector (2 downto 0)`	
	`);`
`end contador;`

`architecture behavior of contador is`
`begin`
	`process(clock, reset)`
	`begin`
		`if(reset = '0') then`
			`result <= (others => '0');` -> número de "0" fica do tamanho do vetor result
		`elsif(clock = '1' and clock'event) then`
			`result <= result + 1;`
		`end if;`
	`end process;`
`end behavior;` 

**OBS:** O contador tem 1 flip-flop para cada bit

Então esse contador de 3 bits tem 3 flip-flops

**OBS:** O others da pra usar com 0 ou 1

-----------------------------------------------------------------------

**OBS:** Quando o que vamos criar é combinacional/sequencial tem que ter CLOCK e RESET. Isso significa que tem flip-flop