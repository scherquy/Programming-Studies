package TP2.Grafos.src;

import java.util.Arrays;

public class BellmanFord {
    // Versão usando lista de adjacência
    public static int[] bellmanFordLista(AdjListGraph g, int src) {
        int n = g.numeroVertices();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
// Relaxar arestas n-1 vezes
        for (int i = 0; i < n - 1; i++) {
            boolean atualizou = false;
            for (int u = 0; u < n; u++) {
                for (Edge e : g.obterAdjacentes(u)) {
                    int v = e.getDestino();
                    int w = e.getPeso();
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + w <
                            dist[v]) {
                        dist[v] = dist[u] + w;
                        atualizou = true;
                    }
                }
            }
            if (!atualizou) break;
        }
        return dist;
    }
    // Versão usando matriz de adjacência
    public static int[] bellmanFordMatriz(AdjMatrixGraph g, int src) {
        int n = g.numeroVertices();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean atualizou = false;
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    int w = g.obterPeso(u, v);
                    if (w != -1 && dist[u] != Integer.MAX_VALUE && dist[u] +
                            w < dist[v]) {
                        dist[v] = dist[u] + w;
                        atualizou = true;
                    }
                }
            }
            if (!atualizou) break;
        }
        return dist;
    }
}