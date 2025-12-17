package TP2.Grafos.src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FloydWharshall {

    private static final int INF = Integer.MAX_VALUE / 4;

    public static void executar(AdjMatrixGraph g) {
        if (g == null) {
            System.out.println("Nenhum grafo fornecido para Floyd-Warshall.");
            return;
        }

        int n = g.numeroVertices();
        int[][] dist = new int[n][n];

        // Inicializa dist[][] a partir da matriz do grafo.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    int w = g.obterPeso(i, j); // retorna -1 se não há aresta
                    if (w == -1) dist[i][j] = INF;
                    else dist[i][j] = w;
                }
            }
        }

        // Cronometra execução
        Stopwatch sw = new Stopwatch();
        sw.iniciar();

        // Algoritmo Floyd–Warshall com checagem para evitar soma INF+INF
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    if (dist[k][j] == INF) continue;
                    int viaK = dist[i][k] + dist[k][j];
                    if (viaK < dist[i][j]) {
                        dist[i][j] = viaK;
                    }
                }
            }
        }

        double tempoMs = sw.parar();
        ResultLogger.registrar("Floyd-Warshall", tempoMs);

        // Detecta ciclo negativo (dist[i][i] < 0)
        boolean negativeCycle = false;
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                negativeCycle = true;
                break;
            }
        }

        // Imprime a matriz resultante
        System.out.println("Matriz de Menores Caminhos (Floyd–Warshall):");
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (dist[i][j] >= INF) sb.append("INF");
                else sb.append(dist[i][j]);
                if (j < n - 1) sb.append(" ");
            }
            System.out.println(sb.toString());
        }
        if (negativeCycle) {
            System.out.println("ATENÇÃO: foi detectado ciclo negativo no grafo.");
        }

        // Grava CSV com resultado do experimento
        String csvFile = "floydwarshall.csv";
        boolean precisaCabecalho = !Files.exists(Paths.get(csvFile));
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(fmt);

        try (FileWriter fw = new FileWriter(csvFile, true);
             PrintWriter pw = new PrintWriter(fw)) {

            if (precisaCabecalho) {
                pw.println("timestamp,vertices,arestas,tempo_ms,negative_cycle");
            }

            pw.printf("%s,%d,%d,%.3f,%b%n",
                    timestamp,
                    g.numeroVertices(),
                    g.numeroArestas(),
                    tempoMs,
                    negativeCycle);
            pw.flush();
        } catch (IOException ex) {
            System.out.println("Erro ao gravar em " + csvFile + ": " + ex.getMessage());
        }
    }
}