package TP2.Grafos.src;

import java.io.BufferedReader;
import java.io.FileReader;

 //Leitor de grafos no formato GTGraph.

public class GTGraphReader {
    public static Graph lerGrafo(String filePath, boolean listaAdjacencia) {
        Graph g = null;
        try (BufferedReader br = new BufferedReader(new
                FileReader(filePath))) {
            String linha;
            int vertices = 0;
// Primeiro, encontra linha 'p' para número de vértices/arestas
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("c")) continue;
                if (linha.startsWith("p")) {
                    String[] partes = linha.split("\\s+");
                    vertices = Integer.parseInt(partes[2]);
// Escolha do tipo de grafo
                    if (listaAdjacencia) {
                        g = new AdjListGraph(vertices);
                    } else {
                        g = new AdjMatrixGraph(vertices);
                    }
                    break;
                }
            }
// Leitura das arestas
            if (g == null) return null;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("a")) {
                    String[] partes = linha.split("\\s+");
                    int u = Integer.parseInt(partes[1]) - 1; // ajustar indice 0-based
                    int v = Integer.parseInt(partes[2]) - 1;
                    int w = Integer.parseInt(partes[3]);
                    g.adicionarAresta(u, v, w);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return g;
    }
}