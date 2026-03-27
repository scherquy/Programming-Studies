//Se clicar no botão o led fica ligado, se clicar de novo no botão o led fica desligado

#include <Arduino.h>

#define ledVerde 4
#define botao 3

void setup(){
    pinMode(ledVerde, OUTPUT);
    pinMode(botao, INPUT);
}

void loop(){
    
}