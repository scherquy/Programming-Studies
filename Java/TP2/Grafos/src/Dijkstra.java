package TP2.Grafos.src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
// Versão usando lista de adjacência

    public static int[] dijkstraLista(AdjListGraph g, int src) {
        int n = g.numeroVertices();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        boolean[] visitado = new boolean[n];
        PriorityQueue<int[]> pq = new
                PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] atual = pq.poll();
            int u = atual[0];
            if (visitado[u]) continue;
            visitado[u] = true;
            for (Edge e : g.obterAdjacentes(u)) {
                int v = e.getDestino();
                int w = e.getPeso();
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
    // Versão usando matriz de adjacência
    public static int[] dijkstraMatriz(AdjMatrixGraph g, int src) {
        int n = g.numeroVertices();
        int[] dist = new int[n];
        boolean[] visitado = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int k = 0; k < n; k++) {
// Escolhe vértice não visitado de menor distância
            int u = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!visitado[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }
            if (u == -1) break;
            visitado[u] = true;
// Relaxa arestas saindo de u
            for (int v = 0; v < n; v++) {
                int peso = g.obterPeso(u, v);
                if (peso != -1 && !visitado[v] && dist[u] !=
                Integer.MAX_VALUE) {
                    if (dist[u] + peso < dist[v]) {
                        dist[v] = dist[u] + peso;
                    }
                }
            }
        }
        return dist;
    }
}