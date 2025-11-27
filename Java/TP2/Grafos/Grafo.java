package TP2.Grafos;

import java.util.List;

public interface Grafo {
    int getNumeroVertices();
    int getNumeroArestas();
    void addAresta(int origem, int destino, int peso);
    List<Integer> vizinhos(int origem);
    int peso(int origem, int destino);
    boolean ehOrientado();
    void imprime();
}
