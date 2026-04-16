// Definição dos pinos conforme sua montagem
const int IN1 = 32; 
const int IN2 = 33;

void setup() {
  // Configura os pinos como saída
  pinMode(IN1, OUTPUT);
  pinMode(IN2, OUTPUT);
  
  // Garante que o motor comece desligado
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, LOW);
}

void loop() {
  // 1. Gira para um lado (Sentido Horário)
  digitalWrite(IN1, HIGH);
  digitalWrite(IN2, LOW);
  delay(2000); // Gira por 2 segundos

  // 2. Para o motor (Freio)
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, LOW);
  delay(1000); // Espera 1 segundo

  // 3. Gira para o outro lado (Sentido Anti-horário)
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, HIGH);
  delay(2000); // Gira por 2 segundos

  // 4. Para o motor
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, LOW);
  delay(3000); // Espera 3 segundos antes de recomeçar
}
