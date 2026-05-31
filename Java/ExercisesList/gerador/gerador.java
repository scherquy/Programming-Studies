/*86) Crie um programa que tenha um procedimento Gerador() que, quando chamado,
mostre a mensagem "Olá, Mundo!" com algum componente visual (linhas)
Ex: Ao chamar Gerador() aparece:
+-------=======------+
Olá, Mundo!
+-------=======------+

87) Crie um programa que melhore o procedimento Gerador() da questão anterior
para que mostre uma mensagem personalizada, passada como parâmetro.
Ex: Ao chamar Gerador("Aprendendo Portugol") aparece:
+-------=======------+
Aprendendo Portugol
+-------=======------+

88) Crie um programa que melhore o procedimento Gerador() da questão anterior
para que mostre uma mensagem vário
Ex: Ao chamar Gerador("Aprendendo Portugol", 4) aparece:
+-------=======------+
Aprendendo Portugol
Aprendendo Portugol
Aprendendo Portugol
Aprendendo Portugol
+-------=======------+ */

package ExercisesList.gerador;

import java.util.Scanner;

public class gerador {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        String word = " ";
        int loop = 0;

        System.out.printf("\nInforme uma frase: ");
        word = read.nextLine();

        System.out.printf("Quantas vezes a mensagem deve repetir: ");
        loop = read.nextInt();

        geradorEscrita(word, loop);
    }

    static void geradorEscrita(String word, int loop){

        for(int x=0; x<loop; x++){
            System.out.printf("\n%s", word);
        }
        System.out.printf("\n\n");
    }
}