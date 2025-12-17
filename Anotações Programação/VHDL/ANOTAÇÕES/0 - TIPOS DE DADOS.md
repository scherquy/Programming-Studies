**std_logic ->** é o tipo de dados mais utilizado e a diferença dele para o Bit é que o std_logic permite nove tipos diferentes de valores:

**U** -> Não inicializada
**X** -> Indefinida
**0**
**1**
**-** -> don´t care
**Z** -> Alta impedância
**W** -> Indefinida fraca
**L** -> 0 fraco
**H** -> 1 fraco

**OBS** -> para usar o std_logic tem que definir a biblioteca std_logic_1164

**VETORES ->** Os tipos bit e std_logic podem ser usados como vetores, por exemplo:

signal j : std_logic_vector (3 downto 0) -> vai da posição 3 para 0

signal j : std_logic_vector (0 to 5) -> vai da posição 0 para 5

**OBS :** Com o std_logic da para acessar as posições dos vetores e trocar os valores


