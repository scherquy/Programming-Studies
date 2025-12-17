package TP2.Grafos.src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void executar(Graph g, int s) {
        if (g == null) {
            System.out.println("Nenhum grafo fornecido para BFS.");
            return;
        }
        int n = g.numeroVertices();
        if (s < 0 || s >= n) {
            System.out.println("Vértice de origem inválido: " + s);
            return;
        }

        boolean[] visitado = new boolean[n];
        Queue<Integer> fila = new LinkedList<>();

        Stopwatch sw = new Stopwatch();
        sw.iniciar();

        // Início da BFS
        visitado[s] = true;
        fila.add(s);
        System.out.println("BFS a partir do vértice " + s + ": ");
        while (!fila.isEmpty()) {
            int u = fila.poll();
            System.out.print(u + " ");
            for (Edge e : g.obterAdjacentes(u)) {
                int v = e.getDestino();
                if (!visitado[v]) {
                    visitado[v] = true;
                    fila.add(v);
                }
            }
        }
        System.out.println();

        double tempoMs = sw.parar();
        ResultLogger.registrar("BFS", tempoMs);

        String csvFile = "bfs.csv";
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
}
