#include <Arduino.h>

#define ledVermelho 5 //ledVermelho na porta 5
#define ledAmarelo 4 //ledAmarelo na porta 4
#define ledVerde 3 //ledVerde na porta 3

void vermelho(int tempo); //função sinal vermelho
void verde(int tempo); //função sinal verde
void amarelo(int tempo); //função sinal amarelo

void setup(){
    pinMode(ledVermelho, OUTPUT); //define porta 5 como saída
    pinMode(ledAmarelo, OUTPUT); //define porta 4 como saída
    pinMode(ledVerde, OUTPUT);  //define porta 3 como saída
}

void loop(){
    vermelho(15);
    verde(15);
    amarelo(3);
}

void vermelho(int tempo){
    digitalWrite(ledVermelho, HIGH); //liga o led vermelho
    digitalWrite(ledAmarelo, LOW); //desliga o led amarelo
    digitalWrite(ledVerde, LOW); //desliga o led verde
    delay(tempo * 1000); //tempo de espera
}

void verde(int tempo){
    digitalWrite(ledVermelho, LOW); //desliga o led vermelho
    digitalWrite(ledAmarelo, LOW); //desliga o led amarelo
    digitalWrite(ledVerde, HIGH); //liga o led verde
    delay(tempo * 1000); //tempo de espera
}

void amarelo(int tempo){
    digitalWrite(ledVermelho, LOW); //desliga o led vermelho
    digitalWrite(ledAmarelo, HIGH); //liga o led amarelo
    digitalWrite(ledVerde, LOW); //desliga o led verde
    delay(tempo * 1000); //tempo de espera
}