#include <Arduino.h>

void setup() {
  pinMode(13, OUTPUT); //Define o pino 13 como saída
}

void loop() {
  digitalWrite(13, HIGH); //Liga o pino 13, voltagem máxima (5 volts)
  delay(1000); //Espera 1 segundo
  digitalWrite(13, LOW); //Desliga o pino 13, voltagem mínima (0 volts) 
  delay(1000); //Espera 1 segundo
}