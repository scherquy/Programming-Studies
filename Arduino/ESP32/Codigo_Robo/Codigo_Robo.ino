#define CUSTOM_SETTINGS
#define INCLUDE_GAMEPAD_MODULE
#include <DabbleESP32.h>

// Motor A
const int IN1 = 32;
const int IN2 = 33;

// Motor B
const int IN3 = 27;
const int IN4 = 25;

void frente() {
  // Motor A para frente
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, HIGH);

  // Motor B para frente
  digitalWrite(IN3, HIGH);
  digitalWrite(IN4, LOW);
}

void tras() {
  // Motor A para trás
  digitalWrite(IN1, HIGH);
  digitalWrite(IN2, LOW);

  // Motor B para trás
  digitalWrite(IN3, LOW);
  digitalWrite(IN4, HIGH);
}

void direita() {
  // Gira usando os dois motores
  digitalWrite(IN1, HIGH);
  digitalWrite(IN2, LOW);

  digitalWrite(IN3, HIGH);
  digitalWrite(IN4, LOW);
}

void esquerda() {
  // Oposto da direita
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, HIGH);

  digitalWrite(IN3, LOW);
  digitalWrite(IN4, HIGH);
}

void parar() {
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, LOW);

  digitalWrite(IN3, LOW);
  digitalWrite(IN4, LOW);
}

void setup() {
  pinMode(IN1, OUTPUT);
  pinMode(IN2, OUTPUT);
  pinMode(IN3, OUTPUT);
  pinMode(IN4, OUTPUT);

  parar();

  Dabble.begin("Carrinho_Manna_ESP32");
}

void loop() {
  Dabble.processInput();

  if (GamePad.isCrossPressed()) {
    tras();
  }
  else if (GamePad.isSquarePressed()) {
    frente();
  }
  else if (GamePad.isRightPressed()) {
    direita();
  }
  else if (GamePad.isLeftPressed()) {
    esquerda();
  }
  else {
    parar();
  }
}