package TP2.Grafos.src;

import java.util.ArrayList;
import java.util.List;

public class AdjListGraph implements Graph {
    private final int vertices;
    private int arestas;
    private boolean direcionado;

    // estrutura por aresta
    private int[] to;
    private int[] weight;
    private int[] next;
    private int capacity;   // capacidade atual dos arrays
    private int edgeCount;  // índice do próximo slot livre (0..edgeCount-1)

    // cabeça por vértice
    private int[] head;

    private static final int INITIAL_CAPACITY = 1024;

    public AdjListGraph(int vertices) {
        this.vertices = vertices;
        this.arestas = 0;
        this.direcionado = true;
        this.capacity = INITIAL_CAPACITY;
        this.edgeCount = 0;

        this.to = new int[capacity];
        this.weight = new int[capacity];
        this.next = new int[capacity];
        this.head = new int[vertices];

        for (int i = 0; i < vertices; i++) head[i] = -1;
    }

    private void ensureCapacity(int needed) {
        if (needed <= capacity) return;
        int newCap = capacity;
        while (newCap < needed) newCap *= 2;
        int[] to2 = new int[newCap];
        int[] weight2 = new int[newCap];
        int[] next2 = new int[newCap];
        System.arraycopy(to, 0, to2, 0, capacity);
        System.arraycopy(weight, 0, weight2, 0, capacity);
        System.arraycopy(next, 0, next2, 0, capacity);
        to = to2;
        weight = weight2;
        next = next2;
        capacity = newCap;
    }

    private void addEdgeInternal(int u, int v, int w) {
        ensureCapacity(edgeCount + 1);
        to[edgeCount] = v;
        weight[edgeCount] = w;
        next[edgeCount] = head[u];
        head[u] = edgeCount;
        edgeCount++;
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
        addEdgeInternal(origem, destino, peso);
        arestas++;
        if (!direcionado) {
            addEdgeInternal(destino, origem, peso);
            arestas++;
        }
    }

    @Override
    public List<Edge> obterAdjacentes(int vertice) {
        List<Edge> lista = new ArrayList<>();
        for (int e = head[vertice]; e != -1; e = next[e]) {
            int v = to[e];
            int w = weight[e];
            lista.add(new Edge(vertice, v, w));
        }
        return lista;
    }

    public int[] getHeadCopy() {
        int[] cp = new int[head.length];
        System.arraycopy(head, 0, cp, 0, head.length);
        return cp;
    }

    public long estimativaMemoriaBytes() {
        long bytes = 0;
        // arrays de int: 4 bytes por elemento (estimativa pura)
        bytes += (long) head.length * 4;
        bytes += (long) capacity * 4 * 3; // to[], weight[], next[]
        return bytes;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEdgeCount() {
        return edgeCount;
    }
}
