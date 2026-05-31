import serial
import serial.tools.list_ports
import time
import sys
import termios
import select

BAUD_RATE = 9600

def escolher_porta():
    portas = list(serial.tools.list_ports.comports())

    if not portas:
        print("Nenhuma porta Serial encontrada.")
        print("Verifique se o Arduino está conectado pelo USB.")
        exit()

    print("Portas encontradas:")
    for i, porta in enumerate(portas):
        print(f"[{i}] {porta.device} - {porta.description}")

    escolha = int(input("Digite o número da porta do Arduino: "))
    return portas[escolha].device

def ativar_leitura_sem_enter():
    fd = sys.stdin.fileno()
    configuracao_antiga = termios.tcgetattr(fd)
    configuracao_nova = termios.tcgetattr(fd)

    # Desativa modo canônico e echo.
    # Assim o Python lê uma tecla sem precisar apertar ENTER.
    configuracao_nova[3] = configuracao_nova[3] & ~(termios.ICANON | termios.ECHO)

    termios.tcsetattr(fd, termios.TCSADRAIN, configuracao_nova)
    return configuracao_antiga

def restaurar_terminal(configuracao_antiga):
    fd = sys.stdin.fileno()
    termios.tcsetattr(fd, termios.TCSADRAIN, configuracao_antiga)

porta_arduino = escolher_porta()

print(f"Conectando na porta {porta_arduino}...")

arduino = serial.Serial(porta_arduino, BAUD_RATE, timeout=1)

# Ao abrir a Serial, muitos Arduinos reiniciam.
# Esse tempo deixa o Arduino reiniciar antes de receber comandos.
time.sleep(2)

print("Conectado!")
print("Deixe esta janela do terminal selecionada.")
print("Aperte W ou ESPAÇO para pular.")
print("Aperte Q para sair.")

config_antiga = ativar_leitura_sem_enter()

try:
    while True:
        # Verifica se alguma tecla foi pressionada
        if select.select([sys.stdin], [], [], 0.05)[0]:
            tecla = sys.stdin.read(1)

            if tecla == 'w' or tecla == 'W' or tecla == ' ':
                arduino.write(b'w')
                arduino.flush()
                print("PULO enviado")

            elif tecla == 'q' or tecla == 'Q':
                print("Encerrando...")
                break

except KeyboardInterrupt:
    print("\nEncerrando...")

finally:
    restaurar_terminal(config_antiga)
    arduino.close()
    print("Porta Serial fechada.")