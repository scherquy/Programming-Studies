**signal** é utilizado para guardar valores que serão usados apenas internamente

É usado para lógicas combinacionais e para lógicas sequenciais

Um **signal** pode assumir qualquer tipo de dado e SEMPRE será declarado dentro da "architecture" antes do "begin"

por exemplo:

entity combinacional is
	port(
		in1 : in std_logic;
		in2 : in std_logic;
		in3 : in std_logic;
		out1 : out std_logic;
		out2 : out std_logic);
end combinacional;

architecture behavior of combinacional is
	signal int_or : std_logic;
	begin
		int_or <= in1 or in2;
		out1 <= (not(int_or)) xor in3;
		out2 <= int or;
	end behavior;

Nesse exemplo a saída 2 (out2) deveria receber o or entre in1 e in2 antes de ser negado, então o signal serviu para fazer isso