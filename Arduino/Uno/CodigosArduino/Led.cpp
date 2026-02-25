#include <Arduino.h>

int led=10; //Variável definida como 10 para usar a porta 10

void setup(){
    pinMode(led, OUTPUT); //Definindo o pino do LED como saída
}

void loop(){
    digitalWrite(led, HIGH); //Liga o led
    delay(2000); //Pausa de 2 segundos
    digitalWrite(led, LOW); //Desliga o led
    delay(2000); //Pausa de 2 segundos
}