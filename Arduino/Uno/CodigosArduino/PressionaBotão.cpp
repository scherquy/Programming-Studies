//Se o botão estiver pressionado o led liga, se soltar o botão o led desliga

#include <Arduino.h>

#define ledVerde 4
#define botao 3

void setup(){
    pinMode(ledVerde, OUTPUT);
    pinMode(botao, INPUT);
}

void loop(){
    if(digitalRead(botao) == HIGH){
        digitalWrite(ledVerde, HIGH);
    }   else{
            digitalWrite(ledVerde, LOW);
        }
}