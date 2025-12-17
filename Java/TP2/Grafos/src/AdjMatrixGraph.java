package TP2.Grafos.src;

import java.util.ArrayList;
import java.util.List;
/**
 * Grafo usando matriz de adjacência.
 */
public class AdjMatrixGraph implements Graph {
    private int vertices;
    private int arestas;
    private boolean direcionado;
    private int[][] matriz;
    public AdjMatrixGraph(int vertices) {
        this.vertices = vertices;
        this.arestas = 0;
        this.direcionado = true; // padrão: direcionado
        matriz = new int[vertices][vertices];
// inicia matriz com -1 (sem aresta)
        for(int i=0; i<vertices; i++){
            for(int j=0; j<vertices; j++){
                matriz[i][j] = -1;
            }
        }
    }
    @Override
    public int numeroVertices() {
        return vertices;
    }
    @Override
    public int numeroArestas() {
        return arestas;
    }
    @Override
    public boolean isDirecionado() {
        return direcionado;
    }
    @Override
    public void setDirecionado(boolean direcionado) {
        this.direcionado = direcionado;
    }
    @Override
    public void adicionarAresta(int origem, int destino) {
        adicionarAresta(origem, destino, 1);
    }
    @Override
    public void adicionarAresta(int origem, int destino, int peso) {
        if (matriz[origem][destino] == -1) {
            arestas++;
        }
        matriz[origem][destino] = peso;
        if (!direcionado) {
            if (matriz[destino][origem] == -1) {
                arestas++;
            }
            matriz[destino][origem] = peso;
        }
    }
    @Override
    public List<Edge> obterAdjacentes(int vertice) {
        List<Edge> lista = new ArrayList<>();
        for (int j = 0; j < vertices; j++) {
            if (matriz[vertice][j] != -1) {
                lista.add(new Edge(vertice, j, matriz[vertice][j]));
            }
        }
        return lista;
    }

    public int obterPeso(int u, int v) {
        return matriz[u][v];
    }

    public int[][] getMatriz() {
        return matriz;
    }
}