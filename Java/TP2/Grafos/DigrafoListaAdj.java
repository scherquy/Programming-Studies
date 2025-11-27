package TP2.Grafos;

import java.util.ArrayList;
import java.util.List;

public class DigrafoListaAdj implements Grafo{
    public int vertices;
    public int arestas;
    public List<List<Aresta>> adj;

    public DigrafoListaAdj(int vertices){
        this.vertices = vertices;
        this.arestas = 0;
        this.adj = new ArrayList<>();

        //para cada vertice eh criada uma lista vazia
        for(int x=0; x<vertices; x++){
            adj.add(new ArrayList<>());
        }
    }

    public int getNumeroVertices(){
        return this.vertices;
    }

    public int getNumeroArestas(){
        return this.arestas;
    }

    //adiciona aresta direcionada
    public void addAresta(int origem, int destino, int peso){
        adj.get(origem).add(new Aresta(destino, peso));

        this.arestas++;
    }

    //retorna os vizinhos do vertice
    public List<Integer> vizinhos(int origem){
        List<Integer> lista = new ArrayList<>();

        //percorre todas as arestas que saem da origem
        for(Aresta aresta : adj.get(origem)){
            lista.add(aresta.destino);
        }

        return lista;
    }

    //retorna o peso da aresta
    public int peso(int origem, int destino){
        for(Aresta aresta : adj.get(origem)){
            if(aresta.destino == destino){
                return aresta.peso;
            }
        }

        return 0;
    }

    public boolean ehOrientado(){

        return true; // orientado
    }

    public void imprime(){
        System.out.println("LISTA DE ADJACENCIA (Digrafo orientado)\n");

        for(int x=0; x<vertices; x++){
            System.out.print(x + " -> ");

            for(Aresta aresta : adj.get(x)){
                System.out.print(aresta + "\t");
            }
            System.out.print("\n");
        }
    }
}