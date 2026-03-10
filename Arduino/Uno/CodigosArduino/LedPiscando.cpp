#include <Arduino.h>

#define ledVermelho 3 //Porta do led
#define max 255 //Energia máxima
#define min 0 //Energia mínima
#define tempo 2

void vermelho(); //Função do led piscando

void setup(){
    pinMode(ledVermelho, OUTPUT); //Definindo led como saída
}

void loop(){
  vermelho(); 
}

void vermelho(){ 
  for(int x=max; x>=min; x--){ //Vai da luz máxima até a luz mínima
    analogWrite(ledVermelho, x); //Muda a frequência do led
    delay(tempo);
  }

  for(int x=min; x<=max; x++){ //Vai do mínimo até o máximo
    analogWrite(ledVermelho, x); //Muda a frequência do led
    delay(tempo);
  }
}