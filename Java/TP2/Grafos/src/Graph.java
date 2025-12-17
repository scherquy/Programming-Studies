package TP2.Grafos.src;

import java.util.List;

public interface Graph {
    int numeroVertices();
    int numeroArestas();
    void adicionarAresta(int origem, int destino);
    void adicionarAresta(int origem, int destino, int peso);
    boolean isDirecionado();
    void setDirecionado(boolean direcionado);
    List<Edge> obterAdjacentes(int vertice);
}