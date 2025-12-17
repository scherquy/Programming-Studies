package TP2.Grafos.src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultLogger {

    public static void registrar1(String algoritmo, double tempoMs,
                                 String arquivo, int vertices, int arestas,
                                 double densidade, String tipo) {
        try (FileWriter fw = new FileWriter("tempos.csv", true)) {

            fw.write(
                    algoritmo + "," +
                    arquivo + "," +
                    tempoMs + "," +
                    vertices + "," +
                    arestas + "," +
                    densidade + "," +
                    tipo + "\n"
            );

        } catch (IOException e) {
            System.out.println("Erro ao registrar tempos.");
        }
    }
    private static final String ARQUIVO = "resultados.csv";

    public static void registrar(String descricao, double tempo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO, true))) {
            pw.println(descricao + "," + tempo);
        } catch (Exception e) {
            System.out.println("Erro ao gravar CSV: " + e.getMessage());
        }
    }


}

