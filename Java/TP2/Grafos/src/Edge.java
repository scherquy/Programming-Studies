package TP2.Grafos.src;
/**
 * Classe que representa uma aresta de um grafo.
 */
public class Edge {
    private int origem;
    private int destino;
    private int peso;
    public Edge(int origem, int destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
    public int getOrigem() {
        return origem;
    }
    public int getDestino() {
        return destino;
    }
    public int getPeso() {
        return peso;
    }
    @Override
    public String toString() {
        return "(" + origem + " -> " + destino + ", p=" + peso + ")";
    }
}
