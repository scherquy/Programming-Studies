package resolucaotela;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ResolucaoTela {
    public static void main(String[] args) {
        Toolkit tk = Toolkit.getDefaultToolkit(); //obtém as informações do S.O
        Dimension dimensao = tk.getScreenSize(); //pega o tamanho da tela

        System.out.println("\nResolução da sua tela: " + (int)dimensao.getWidth() + " x " + (int)dimensao.getHeight() + "\n");
    }
    
}