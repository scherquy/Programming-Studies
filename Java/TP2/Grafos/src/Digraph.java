package TP2.Grafos.src;

import java.util.*;

public class Digraph {

    /** Verifica se o grafo é direcionado */
    public static void verificarDirecionamento(Graph g) {
        System.out.println("O grafo é " + (g.isDirecionado() ? "DIRECIONADO" : "NÃO direcionado"));
    }

    /** Ordenação topológica (somente para grafos dirigidos e acíclicos) */
    public static void topologicalSort(Graph g) {
        if (!g.isDirecionado()) {
            System.out.println("Topological Sort só funciona para grafos direcionados!");
            return;
        }

        int n = g.numeroVertices();
        int[] grau = new int[n];

        for (int u = 0; u < n; u++)
            for (Edge e : g.obterAdjacentes(u))
                grau[e.getDestino()]++;

        Queue<Integer> fila = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (grau[i] == 0) fila.add(i);

        List<Integer> ordem = new ArrayList<>();

        while (!fila.isEmpty()) {
            int u = fila.poll();
            ordem.add(u);
            for (Edge e : g.obterAdjacentes(u)) {
                int v = e.getDestino();
                if (--grau[v] == 0) fila.add(v);
            }
        }

        if (ordem.size() != n) {
            System.out.println("O grafo possui ciclo. Topological Sort impossível.");
        } else {
            System.out.println("Ordenação topológica:");
            System.out.println(ordem);
        }
    }
}
