// Definição dos pinos para os dois motores
const int IN1 = 32; 
const int IN2 = 33;
const int IN3 = 27; 
const int IN4 = 26;

void setup() {
  // Configura todos os pinos como saída
  pinMode(IN1, OUTPUT);
  pinMode(IN2, OUTPUT);
  pinMode(IN3, OUTPUT);
  pinMode(IN4, OUTPUT);
  
  // Começa com tudo desligado por segurança
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, LOW);
  digitalWrite(IN3, LOW);
  digitalWrite(IN4, LOW);
}

void loop() {
  // --- ANDAR PARA FRENTE ---
  // Motor A liga
  digitalWrite(IN1, HIGH);
  digitalWrite(IN2, LOW);
  // Motor B liga
  digitalWrite(IN3, HIGH);
  digitalWrite(IN4, LOW);
  
  delay(3000); // Anda por 3 segundos

  // --- PARAR ---
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, LOW);
  digitalWrite(IN3, LOW);
  digitalWrite(IN4, LOW);
  
  delay(3000); // Fica parado por 3 segundos
}
