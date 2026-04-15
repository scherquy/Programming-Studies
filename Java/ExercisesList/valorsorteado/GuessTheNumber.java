/*55) [DESAFIO] Vamos melhorar o jogo que fizemos no exercício 32. A partir de
agora, o computador vai sortear um número entre 1 e 10 e o jogador vai ter 4
tentativas para tentar acertar.

32) [DESAFIO] Crie um jogo onde o computador vai sortear um número entre 1 e 5 o
jogador vai tentar descobrir qual foi o valor sorteado.*/

package ExercisesList.valorsorteado;

import java.util.Scanner;
import java.math.*;

public class GuessTheNumber {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        
        byte valorSorteado = (byte) 0;
        byte valorEscolhido = (byte) 0;

        valorSorteado = (byte) (1 + Math.random() * (10 - 1));

        for(int x = 4; x>0; x--){
            System.out.printf("\nVocê tem %d tentativa(s)\n\nInforme um valor (entre 1 e 10): ", x);
            valorEscolhido = read.nextByte();

            if(valorEscolhido == valorSorteado){
                System.out.printf("\nO número sorteado é %d. Parabéns, você acertou\n\n", valorSorteado);
                break;
            }   else{
                    System.out.printf("\nVocê errou. Tente novamente\n");
                }
        }

        if(valorEscolhido != valorSorteado){
            System.out.printf("\nAs suas chances acabaram e você não acertou. O valor sorteado é %d\n\n", valorSorteado);
        }
    }
}
