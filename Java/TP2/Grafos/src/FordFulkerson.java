package TP2.Grafos.src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FordFulkerson {

    // BFS para encontrar caminho aumentante na rede residual
    private static boolean bfsResidual(int[][] residual, int s, int t, int[] parent) {
        int n = residual.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < n; v++) {
                if (!visited[v] && residual[u][v] > 0) {
                    visited[v] = true;
                    parent[v] = u;
                    q.add(v);
                    if (v == t) return true;
                }
            }
        }
        return false;
    }

    public static void executar(Graph g, int s, int t) {
        if (g == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }

        if (!g.isDirecionado()) {
            System.out.println("Ford–Fulkerson requer grafo direcionado.");
            return;
        }

        int n = g.numeroVertices();
        if (s < 0 || s >= n || t < 0 || t >= n) {
            System.out.println("Origem ou destino inválidos.");
            return;
        }

        // Cria e inicializa matriz residual (capacidade)
        int[][] residual = new int[n][n]; // inicializa com 0

        // Preencher residual a partir da representação
        if (g instanceof AdjMatrixGraph) {
            AdjMatrixGraph mg = (AdjMatrixGraph) g;
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    int w = mg.obterPeso(u, v);
                    if (w != -1) {
                        residual[u][v] = w;
                    }
                }
            }
        } else {
            for (int u = 0; u < n; u++) {
                for (Edge e : g.obterAdjacentes(u)) {
                    int v = e.getDestino();
                    int w = e.getPeso();
                    // Soma capacidades se houver múltiplas arestas u->v
                    residual[u][v] += w;
                }
            }
        }

        int[] parent = new int[n];
        int maxFlow = 0;

        Stopwatch sw = new Stopwatch();
        sw.iniciar();

        while (bfsResidual(residual, s, t, parent)) {
            int pathFlow = Integer.MAX_VALUE;

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residual[u][v]);
            }

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                residual[u][v] -= pathFlow;
                residual[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        double tempoMs = sw.parar();
        ResultLogger.registrar("FordFulkerson", tempoMs);

        // saída para o usuário
        System.out.println("\nFluxo máximo (Ford–Fulkerson / Edmonds–Karp): " + maxFlow);
        System.out.printf("Tempo de execução: %.3f ms%n", tempoMs);

        // gravação em CSV
        String csv = "fordfulkerson.csv";
        boolean cab = !Files.exists(Paths.get(csv));

        try (PrintWriter pw = new PrintWriter(new FileWriter(csv, true))) {
            if (cab)
                pw.println("timestamp,vertices,arestas,origem,destino,fluxo_maximo,tempo_ms");

            String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            pw.printf("%s,%d,%d,%d,%d,%d,%.3f%n",
                    ts, g.numeroVertices(), g.numeroArestas(),
                    s, t, maxFlow, tempoMs);

        } catch (IOException ex) {
            System.out.println("Erro ao escrever fordfulkerson.csv: " + ex.getMessage());
        }
    }
}
