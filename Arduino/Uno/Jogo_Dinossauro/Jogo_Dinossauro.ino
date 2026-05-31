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
void drawScore();
bool teclaPuloPressionada();

#define BUZZER 8

#define MAX_JUMP_TIME 1200

#define PONTOS_VELOCIDADE2 300
#define PONTOS_VELOCIDADE3 600
#define PONTOS_VELOCIDADE4 1200
#define PONTOS_VELOCIDADE5 2400
#define PONTOS_VELOCIDADE6 5000

#define CHANCHE_GERACAO_CACTOS 60
#define TEMPO_GERACAO_CACTOS 2000
#define ESTILO_CACTO 1

#define CHANCE_GERACAO_PASSAROS_ALTO 40
#define TEMPO_GERACAO_PASSAROS_ALTO 2000
#define ESTILO_PASSAROS_ALTO_ASA_CIMA 2
#define ESTILO_PASSAROS_ALTO_ASA_BAIXO 3

LiquidCrystal lcd(12, 11, 5, 4, 3, 2); // RS, E, D4, D5, D6, D7

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

bool jumping = false;
bool started = false;

unsigned int dinoY = 1;

unsigned long jumpTime = 0;
unsigned long lastDrawCacto = 0;
unsigned long lastDrawPassaro = 0;
unsigned long lastGeneratedCacto = 0;
unsigned long lastGeneratedPassaro = 0;
unsigned long startTime = 0;
unsigned long lastAsaFlap = 0;

int cacto[16];
int cactoEstilo[16];
int cactoCont = 0;

int passaro[16];
int passaroEstilo[16];
int passaroCont = 0;

int velocidadeCacto = 600;
int velocidadePassaro = 600;

bool teclaPuloPressionada() {
  bool pressionou = false;

  while (Serial.available() > 0) {
    char tecla = Serial.read();

    if (tecla == 'w' || tecla == 'W' || tecla == ' ') {
      pressionou = true;
    }
  }

  return pressionou;
}

void clearPlayer() {
  lcd.setCursor(4, dinoY);
  lcd.print(" ");
}

void gameOver() {
  started = false;
  clearCacto();
  clearPassaro();

  lcd.clear();
  lcd.setCursor(3, 0);
  lcd.print("GAME OVER");

  lcd.setCursor(3, 1);
  lcd.print((millis() - startTime) / 100);

  tone(BUZZER, 415);
  delay(80);
  tone(BUZZER, 302);
  delay(50);
  noTone(BUZZER);
  delay(400);
}

void allBlocks() {
  for (int x = 0; x < 16; x++) {
    for (int y = 0; y < 2; y++) {
      lcd.setCursor(x, y);
      lcd.write(byte(6));
    }
  }
}

void checkSpeed() {
  if ((millis() - startTime) / 100 >= PONTOS_VELOCIDADE2 && velocidadeCacto > 500 && velocidadePassaro > 500) {
    velocidadeCacto = 500;
    velocidadePassaro = 500;
    allBlocks();
  } else if ((millis() - startTime) / 100 >= PONTOS_VELOCIDADE3 && velocidadeCacto > 400 && velocidadePassaro > 400) {
    velocidadeCacto = 400;
    velocidadePassaro = 400;
    allBlocks();
  } else if ((millis() - startTime) / 100 >= PONTOS_VELOCIDADE4 && velocidadeCacto > 300 && velocidadePassaro > 300) {
    velocidadeCacto = 300;
    velocidadePassaro = 300;
    allBlocks();
  } else if ((millis() - startTime) / 100 >= PONTOS_VELOCIDADE5 && velocidadeCacto > 200 && velocidadePassaro > 200) {
    velocidadeCacto = 200;
    velocidadePassaro = 200;
    allBlocks();
  } else if ((millis() - startTime) / 100 >= PONTOS_VELOCIDADE6 && velocidadeCacto > 100 && velocidadePassaro > 100) {
    velocidadeCacto = 100;
    velocidadePassaro = 100;
    allBlocks();
  }
}

void drawPlayer(int y, bool clean) {
  int comp[2] = {1, 0};

  if (clean) {
    lcd.setCursor(4, comp[y]);
    lcd.print(" ");
  }

  lcd.setCursor(4, y);
  lcd.write(byte(0));
}

void addCacto() {
  for (int x = 0; x < passaroCont; x++) {
    if (passaro[x] > 8) return;
  }

  for (int x = 0; x < cactoCont; x++) {
    if (cacto[x] > 8) return;
  }

  for (int x = 0; x < 16; x++) {
    if (cacto[x] == -1) {
      cacto[x] = 15;
      cactoEstilo[x] = random(1, 4);
      cactoCont++;
      break;
    }
  }
}

void clearCacto() {
  for (int x = 0; x < 16; x++) {
    cacto[x] = -1;
    cactoEstilo[x] = 1;
  }

  cactoCont = 0;
}

void removePrimeiroCacto() {
  for (int x = 0; x < 15; x++) {
    cacto[x] = cacto[x + 1];
    cactoEstilo[x] = cactoEstilo[x + 1];
  }

  cacto[15] = -1;
  cactoEstilo[15] = 1;

  if (cactoCont > 0) {
    cactoCont--;
  }
}

void drawCacto() {
  bool move = false;

  for (int x = 0; x < cactoCont; x++) {
    if (millis() - lastDrawCacto >= velocidadeCacto) {
      cacto[x] = cacto[x] - 1;
      move = true;
    }

    if (cacto[x] == 4 && dinoY == 1) {
      started = false;
      gameOver();
      break;
    }

    if (cacto[x] > -1) {
      lcd.setCursor(cacto[x], 1);
      lcd.write(cactoEstilo[x]);
    } else {
      removePrimeiroCacto();
      x--;
    }
  }

  if (move) {
    lastDrawCacto = millis();
  }
}

void gerarCacto() {
  if (millis() - lastGeneratedCacto < TEMPO_GERACAO_CACTOS) {
    return;
  }

  int chance = random(0, velocidadeCacto);

  if (chance < CHANCHE_GERACAO_CACTOS) {
    addCacto();
    lastGeneratedCacto = millis();
  }
}

void addPassaro() {
  for (int x = 0; x < cactoCont; x++) {
    if (cacto[x] > 8) return;
  }

  for (int x = 0; x < passaroCont; x++) {
    if (passaro[x] > 8) return;
  }

  for (int x = 0; x < 16; x++) {
    if (passaro[x] == -1) {
      passaro[x] = 15;
      passaroEstilo[x] = random(4, 6);
      passaroCont++;
      break;
    }
  }
}

void clearPassaro() {
  for (int x = 0; x < 16; x++) {
    passaro[x] = -1;
    passaroEstilo[x] = 4;
  }

  passaroCont = 0;
}

void removePrimeiroPassaro() {
  for (int x = 0; x < 15; x++) {
    passaro[x] = passaro[x + 1];
    passaroEstilo[x] = passaroEstilo[x + 1];
  }

  passaro[15] = -1;
  passaroEstilo[15] = 4;

  if (passaroCont > 0) {
    passaroCont--;
  }
}

void drawPassaro() {
  bool move = false;

  for (int x = 0; x < passaroCont; x++) {
    if (millis() - lastDrawPassaro >= velocidadePassaro) {
      passaro[x] = passaro[x] - 1;
      move = true;
    }

    if (passaro[x] == 4 && dinoY == 1) {
      started = false;
      gameOver();
      break;
    }

    if (passaro[x] > -1) {
      if (millis() - lastAsaFlap >= 300) {
        lastAsaFlap = millis();

        for (int y = 0; y < passaroCont; y++) {
          passaroEstilo[y] = (passaroEstilo[y] == 4) ? 5 : 4;
        }
      }

      lcd.setCursor(passaro[x], 1);
      lcd.write(passaroEstilo[x]);
    } else {
      removePrimeiroPassaro();
      x--;
    }
  }

  if (move) {
    lastDrawPassaro = millis();
  }
}

void gerarPassaro() {
  if (millis() - lastGeneratedPassaro < TEMPO_GERACAO_PASSAROS_ALTO) {
    return;
  }

  int chance = random(0, velocidadePassaro);

  if (chance < CHANCE_GERACAO_PASSAROS_ALTO) {
    addPassaro();
    lastGeneratedPassaro = millis();
  }
}

void setup() {
  Serial.begin(9600);

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
  lcd.setCursor(4, 1);
  lcd.print("W/ESPACO");

  pinMode(BUZZER, OUTPUT);

  randomSeed(analogRead(0));

  clearCacto();
  clearPassaro();
}

void loop() {
  bool pulo = teclaPuloPressionada();

  if (started) {
    lcd.clear();
    checkSpeed();

    if (millis() - jumpTime >= MAX_JUMP_TIME * 0.1) {
      noTone(BUZZER);
    }

    if (pulo && !jumping) {
      jumpTime = millis();
      jumping = true;
      drawPlayer(--dinoY, true);
      tone(BUZZER, 800);
    }

    if (jumping && millis() - jumpTime > MAX_JUMP_TIME) {
      jumping = false;
      drawPlayer(++dinoY, true);
      noTone(BUZZER);
    }

    gerarCacto();
    gerarPassaro();

    drawPlayer(dinoY, false);
    drawCacto();
    drawPassaro();
    drawScore();

    delay(150);

  } else {
    if (pulo) {
      started = true;
      startTime = millis();

      velocidadeCacto = 600;
      velocidadePassaro = 600;

      clearCacto();
      clearPassaro();

      tone(BUZZER, 1440);
      delay(200);
      noTone(BUZZER);
    }
  }
}

void drawScore() {
  unsigned long score = (millis() - startTime) / 100;

  lcd.setCursor(13, 0);

  if (score < 10) {
    lcd.print("  ");
  } else if (score < 100) {
    lcd.print(" ");
  }

  lcd.print(score);
}