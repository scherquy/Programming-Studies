Para definir saídas ou entradas com mais de 1 bit temos que usar o "vector". Por exemplo:

uma entrada com 2 bits:

in1 : in std_logic_vector (1 downto 0);

Quando for utilizar o if, else, etc... se for usar um valor de 1 bit usamos o valor entre 'valor_do_bit' se for mais de 1 bit usamos o valor entre "valor_do_bit"