package TP2.Grafos.src;

public class GraphWriter {

    public static void escreverGrafo(Graph g) {
        if (g == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }
        System.out.println("Grafo com " + g.numeroVertices() + " vértices e " + g.numeroArestas() + " arestas.");
        System.out.println("Direcionado? " + (g.isDirecionado() ? "Sim" : "Não"));
        for (int u = 0; u < g.numeroVertices(); u++) {
            System.out.print("Vértice " + u + ": ");
            for (Edge e : g.obterAdjacentes(u)) {
                System.out.print(" -> [" + e.getDestino() + " (peso=" +
                        e.getPeso() + ")]");
            }
            System.out.println();
        }
    }
}