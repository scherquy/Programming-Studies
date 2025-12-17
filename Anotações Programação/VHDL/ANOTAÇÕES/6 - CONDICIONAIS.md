**WHEN / ELSE (Combinacional) ->** Usar para atribuições simples e diretas, por exemplo:

- Em architecture (fora do process)
- Para muxes simples

`entity mux is`
	`port(`
		`A : in std_logic; -- Entrada A`
		`B : in std_logic; -- Entrada B`
		`S : in std_logic; -- Seletor`
		`M : out std_logic); -- Saída Multiplexada`
`end mux;`

`architecture behavior of mux is`
	`begin`
		`M <= A when S = ‘0’ else -- M recebe o valor de A quando S é zero.`
			  `B; -- M recebe o valor de B para outros valores.`
`end behavior;` 

-----------------------------------------------------------------------

**WITH / SELECT / WHEN (Combinacional) ->** Para seleção de valores específicos

- Decodificadores
- Muxes com seleção explícita
- Casos onde todos os valores são conhecidos

`with selector select`
    `output <= value1 when "00",`
              `value2 when "01",`
              `value3 when "10",`
              `value4 when others;`

-----------------------------------------------------------------------

**IF / ELSIF / ELSE (Sequencial) ->** Usado dentro de process para lógica sequencial

- Dentro de process (clocked ou combinacionais)
- Lógica complexa com múltiplas escolhas
- Registradores e máquinas de estado

`process(clk)`
`begin`
    `if rising_edge(clk) then`
        `if condition1 then`
            `-- código`
        `elsif condition2 then`
            `-- código`
        `else`
            `-- código`
        `end if;`
    `end if;`
`end process;`

-----------------------------------------------------------------------

**CASE / WHEN (Sequencial) ->** Para seleção baseada em valores específicos dentro de process

- Máquinas de estado
- Decodificação de instruções
- Quando há muitos valores específicos para testar

`architecture behavior of mux is`
`begin`
	`process (A, B, C, D, S)`
	`begin`
		`case S is`
			`when ‘00’ => M <= A ;`
			`when ‘01’ => M <= B;`
			`when ‘10’ => M <= C;`
			`when others => M <= D ;`
		`end case;`
	`end process;`
`end behavior;`
