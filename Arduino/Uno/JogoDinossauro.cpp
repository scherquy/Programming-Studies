#include <LiquidCrystal.h>

void clearPlayer();
void gameOver();
void allBlocks();
void checkSpeed();
void drawPlayer(int y, bool clean);
void addCacto();
void clearCacto();
void removePrimeiroCacto();
void drawCacto();
void gerarCacto();
void addPassaro();
void clearPassaro();
void removePrimeiroPassaro();
void drawPassaro();
void gerarPassaro();
void setup();
void loop();

#define JUMP 9
#define BUZZER 8

#define MAX_JUMP_TIME 1200

#define PONTOS_VELOCIDADE2 300
#define PONTOS_VELOCIDADE3 600
#define PONTOS_VELOCIDADE4 1200
#define PONTOS_VELOCIDADE5 2400
#define PONTOS_VELOCIDADE6 5000

#define CHANCHE_GERACAO_CACTOS 60
#define TEMPO_GERACAO_CACTOS 1000
#define ESTILO_CACTO 1

#define CHANCE_GERACAO_PASSAROS_ALTO 30
#define TEMPO_GERACAO_PASSAROS_ALTO 2000
#define ESTILO_PASSAROS_ALTO_ASA_CIMA 2
#define ESTILO_PASSAROS_ALTO_ASA_BAIXO 3

LiquidCrystal lcd(12, 11, 5, 4, 3, 2); //RS, E, D4, D5, D6, D7

byte dino[] = {
  B01110,
  B01011,
  B01111,
  B00110,
  B10111,
  B11110,
  B01110,
  B01010
};

byte cacto1[] = {
  B00100,
  B00101,
  B10101,
  B10101,
  B01101,
  B00110,
  B00100,
  B00100
};

byte cacto2[] = {
  B00100,
  B10100,
  B10101,
  B10101,
  B10110,
  B01100,
  B00100,
  B00100
};

byte cacto3[] = {
  B00100,
  B10101,
  B10101,
  B10101,
  B01110,
  B00100,
  B00100,
  B00100
};

byte passaroumasacima[] = {
  B00100,
  B00110,
  B11111,
  B01100,
  B00000,
  B00000,
  B00000,
  B00000
};

byte passaroumasabaixo[] = {
  B00000,
  B00000,
  B11111,
  B01110,
  B00110,
  B00000,
  B00000,
  B00000
};

byte block[] = {
  B11111,
  B11111,
  B11111,
  B11111,
  B11111,
  B11111,
  B11111,
  B11111
};

bool jumping = false; // dinossauro no ar?
bool started = false; // o jogo começou?

unsigned int dinoY = 1; // o dinossauro está no chão (linha 1)

unsigned long jumpTime = 0; // o tempo em que o pulo começou
unsigned long lastDrawCacto = 0;// quando os cactos foram movidos pela ultima vez
unsigned long lastDrawPassaro = 0;// quando os passaros foram movidos pela ultima vez
unsigned long lastGeneratedCacto = 0; // quando o ultimo cacto foi gerado
unsigned long lastGeneratedPassaro = 0;// quando o ultimo passaro foi gerado
unsigned long startTime = 0; // quando o jogo começou

int cacto[16]; // Vetor que guarda a posição horizontal de cada cacto na tela
int cactoCont = 0; // diz quantos cactos estão aativos
int passaro[16];
int passaroCont = 0;

int velocidadeCacto = 600, velocidadePassaro = 600; //Intervalo entre movimentos dos cactos e passaros em ms

void clearPlayer(){ // Apaga o dinossauro da tela colocando um espaço na posição dele
    lcd.setCursor(4, dinoY); // o dinossauro sempre fica na coluna 4
    lcd.print(" ");
}

void gameOver(){
    started = false; //para o jogo
    clearCacto(); //remove os cactos
    clearPassaro(); //remove os passaros
    lcd.clear();
    lcd.setCursor(3, 0);
    lcd.print("GAME OVER");
    lcd.setCursor(3, 1);
    lcd.print((millis() - startTime) / 100); //pontuação na tela
    tone(BUZZER, 415);
    delay(80);
    tone(BUZZER, 302);
    delay(50);
    noTone(BUZZER);
    delay(400);
}

void allBlocks(){ // essa função preenche o lcd com blocos pretos
  for(int x=0; x<16; x++){
    for(int y=0; y<2; y++){
      lcd.setCursor(x, y);
      lcd.write(byte(6));
    }
  }
}

void checkSpeed(){ //essa função verifica a pontuação atual e ve se já é hora de mudar a velocidade
  if((millis() - startTime) / 100 >= PONTOS_VELOCIDADE2 && velocidadeCacto > 500 && velocidadePassaro > 500){
    velocidadeCacto = 500;
    velocidadePassaro = 500;
    allBlocks();
  } else if((millis() - startTime) / 100 >= PONTOS_VELOCIDADE3 && velocidadeCacto > 400 && velocidadePassaro > 400){
      velocidadeCacto = 400;
      velocidadePassaro = 400;
      allBlocks();
    } else if((millis() - startTime) / 100 >= PONTOS_VELOCIDADE4 && velocidadeCacto > 300 && velocidadePassaro > 300){
        velocidadeCacto = 300;
        velocidadePassaro = 300;
        allBlocks();
      } else if((millis() - startTime) / 100 >= PONTOS_VELOCIDADE5 && velocidadeCacto > 200 && velocidadePassaro > 200){
          velocidadeCacto = 200;
          velocidadePassaro = 200;
          allBlocks();
        } else if((millis() - startTime) / 100 >= PONTOS_VELOCIDADE6 && velocidadeCacto > 100 && velocidadePassaro > 100){
            velocidadeCacto = 100;
            velocidadePassaro = 100;
            allBlocks();
          }
}

void drawPlayer(int y, bool clean){ // essa função desenha o dinossauro na linha y. se clean=true apaga a linha onde o dino estava  para não ter rastro quando pula
  int comp[2] = {1, 0};
  if(clean){
    lcd.setCursor(4, comp[y]);
    lcd.print(" ");
  }

  lcd.setCursor(4, y);
  lcd.write(byte(0));
}

void addCacto(){
  for(int x=0; x<16; x++){
    if(cacto[x] == -1){ //encontra um slot vazio no array
      if(x>0 && cacto[x-1] == 14 && velocidadeCacto == 500) break; //evita dois cactos grudados no inicio
      cacto[x] = 15; // coloca o cacto bem na direita
      cactoCont++;
      break;
    }
  }
}

void clearCacto(){
  for(int x=0; x<16; x++){
    cacto[x] = -1;
    cactoCont = 0;
  }
}

void removePrimeiroCacto(){ // remove o cacto mais a esquerda
  for(int x=0; x<16; x++){
    cacto[x] = cacto[x+1]; //desloca todos uma posição para a esquerda
    if(x >= cactoCont){
      cacto[x] = -1;
      break;
    }
  }

  cactoCont--;
}

void drawCacto(){ //move, desenha e verifica a colisão de todos os cactos
  bool move = false;
  
  for(int x=0; x<cactoCont; x++){
    if(millis() - lastDrawCacto >= velocidadeCacto){
      cacto[x] = cacto[x] - 1; //movimenta o cacto uma coluna para a esquerda
      move = true;
    }

    if(cacto[x] == 4 && dinoY == 1){ // se o cacto chegar no dinossauro (coluna 4) e o dino estiver no chão = game over
      started = false;
      gameOver();
      break;
    }

    lcd.setCursor(cacto[x], 1);
    if(cacto[x] > -1){
      lcd.write(ESTILO_CACTO); // desenha o cacto
    } else{
      removePrimeiroCacto(); //cacto saiu da tela
      x--;
    }
  }

  if(move){
    lastDrawCacto = millis(); //atualiza o tempo do ultimo movimento
  }
}

void gerarCacto(){ //gera cactos aleatoriamente

  if(millis() - lastGeneratedCacto < TEMPO_GERACAO_CACTOS){ //ainda não passou tempo suficiente
    return;
  }

  int chance = random(0, velocidadeCacto); // sorteia um número de 0 até velocidade do cacto

  if(chance < CHANCHE_GERACAO_CACTOS){ //se for menor que 60 gera um cacto
    addCacto();
    lastGeneratedCacto = millis();
  }
}

void addPassaro(){
  for(int x=0; x<16; x++){
    if(passaro[x] == -1){ //encontra um slot vazio no array
      if(x>0 && passaro[x-1] == 14 && velocidadePassaro == 500) break; //evita dois passaros grudados no inicio
      passaro[x] = 15; // coloca o passaro bem na direita
      passaroCont++;
      break;
    }
  }
}

void clearPassaro(){
  for(int x=0; x<16; x++){
    passaro[x] = -1;
    passaroCont = 0;
  }
}

void removePrimeiroPassaro(){ // remove o cacto mais a esquerda
  for(int x=0; x<16; x++){
    passaro[x] = passaro[x+1]; //desloca todos uma posição para a esquerda
    if(x >= passaroCont){
      passaro[x] = -1;
      break;
    }
  }

  passaroCont--;
}

void drawPassaro(){ //move, desenha e verifica a colisão de todos os cactos
  bool move = false;
  
  for(int x=0; x<passaroCont; x++){
    if(millis() - lastDrawPassaro >= velocidadePassaro){
      passaro[x] = passaro[x] - 1; //movimenta o cacto uma coluna para a esquerda
      move = true;
    }

    if(passaro[x] == 4 && dinoY == 1){ // se o cacto chegar no dinossauro (coluna 4) e o dino estiver no chão = game over
      started = false;
      gameOver();
      break;
    }

    lcd.setCursor(passaro[x], 1);
    if(passaro[x] > -1){
      lcd.write(ESTILO_PASSAROS_ALTO_ASA_BAIXO); // desenha o cacto
    } else{
      removePrimeiroPassaro(); //cacto saiu da tela
      x--;
    }
  }

  if(move){
    lastDrawPassaro = millis(); //atualiza o tempo do ultimo movimento
  }
}

void gerarPassaro(){ //gera cactos aleatoriamente

  if(millis() - lastGeneratedPassaro < TEMPO_GERACAO_PASSAROS_ALTO){ //ainda não passou tempo suficiente
    return;
  }

  int chance = random(0, velocidadePassaro); // sorteia um número de 0 até velocidade do cacto

  if(chance < CHANCE_GERACAO_PASSAROS_ALTO){ //se for menor que 60 gera um cacto
    addPassaro();
    lastGeneratedPassaro = millis();
  }
}

void setup(){
  lcd.begin(16, 2);
  lcd.createChar(0, dino);
  lcd.createChar(1, cacto1);
  lcd.createChar(2, cacto2);
  lcd.createChar(3, cacto3);
  lcd.createChar(4, passaroumasacima);
  lcd.createChar(5, passaroumasabaixo);
  lcd.createChar(6, block);
  lcd.setCursor(5, 0);
  lcd.print("APERTE");
  lcd.setCursor(5, 1);
  lcd.print("O PULO");
  pinMode(JUMP, INPUT);
  pinMode(BUZZER, OUTPUT);
  randomSeed(analogRead(0));
  clearCacto();
  clearPassaro();
}

void loop(){
  if(started){
    lcd.clear();
    checkSpeed();

    if(millis() - jumpTime >= MAX_JUMP_TIME * 0.1){
      noTone(BUZZER);
    }

    if(digitalRead(JUMP)){
      if(!jumping){
        jumpTime = millis();
        jumping = true;
        drawPlayer(--dinoY, true);
        tone(BUZZER, 800);
      }

      if(jumping){
        if(millis() - jumpTime > MAX_JUMP_TIME){
          jumping = false;
          drawPlayer(++dinoY, true);
          noTone(BUZZER);
        }
      }
    } else{
        if(jumping){
          jumping = false;
          drawPlayer(++dinoY, true);
        }
      }

      gerarCacto();
      gerarPassaro();
      drawPlayer(dinoY, false);
      drawCacto();
      drawPassaro();
      delay(150);
  } else{
      if(digitalRead(JUMP)){
        started = true;
        startTime = millis();
        tone(BUZZER, 1440);
        delay(200);
        noTone(BUZZER);
      }
    }
}