package TP2.Grafos.src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DFS {
    private static boolean[] visitado;

    public static void executar(Graph g, int s) {
        if (g == null) {
            System.out.println("Nenhum grafo fornecido para DFS.");
            return;
        }
        int n = g.numeroVertices();
        if (s < 0 || s >= n) {
            System.out.println("Vértice de origem inválido: " + s);
            return;
        }

        visitado = new boolean[n];

        // Iniciar cronômetro
        Stopwatch sw = new Stopwatch();
        sw.iniciar();

        System.out.print("DFS a partir do vértice " + s + ": ");
        dfsRecursivo(g, s);
        System.out.println();

        double tempoMs = sw.parar();
        ResultLogger.registrar("DFS", tempoMs);

        String csvFile = "dfs.csv";
        boolean precisaCabecalho = !Files.exists(Paths.get(csvFile));
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(fmt);

        try (FileWriter fw = new FileWriter(csvFile, true);
             PrintWriter pw = new PrintWriter(fw)) {

            if (precisaCabecalho) {
                pw.println("timestamp,vertices,arestas,origem,tempo_ms");
            }
            pw.printf("%s,%d,%d,%d,%.3f%n", timestamp, g.numeroVertices(), g.numeroArestas(), s, tempoMs);
            pw.flush();
        } catch (IOException ex) {
            System.out.println("Erro ao gravar em " + csvFile + ": " + ex.getMessage());
        }
    }

    private static void dfsRecursivo(Graph g, int u) {
        visitado[u] = true;
        System.out.print(u + " ");
        for (Edge e : g.obterAdjacentes(u)) {
            int v = e.getDestino();
            if (!visitado[v]) {
                dfsRecursivo(g, v);
            }
        }
    }
}
