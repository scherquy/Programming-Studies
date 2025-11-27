package TP2.Grafos;

import java.util.ArrayList;
import java.util.List;

public class DigrafoMatrizAdj implements Grafo{
    public int vertices;
    public int arestas;
    public int [][] matriz;

    public DigrafoMatrizAdj(int vertices){
        this.vertices = vertices;
        this.arestas = 0;
        this.matriz = new int[vertices][vertices];

        //inicializa sem arestas
        for(int x=0; x<vertices; x++){
            for(int y=0; y<vertices; y++){
                matriz[x][y] = 0;
            }
        }
    }

    public int getNumeroVertices(){
        return this.vertices;
    }

    public int getNumeroArestas(){
        return this.arestas;
    }

    public void addAresta(int origem, int destino, int peso){
        this.matriz[origem][destino] = peso;

        this.arestas++;
    }

    public List<Integer> vizinhos(int origem){
        List<Integer> lista = new ArrayList<>();

        for(int x=0; x<vertices; x++){
            if(this.matriz[origem][x] != 0){
                lista.add(x);
            }
        }

        return lista;
    }

    public int peso(int origem, int destino){

        return this.matriz[origem][destino];
    }

    public boolean ehOrientado(){
        return true; //orientado
    }

    public void imprime() {
        System.out.println("MATRIZ DE ADJACÊNCIA (Digrafo orientado)\n");

        for(int x=0; x<vertices; x++){
            for(int y=0; y<vertices; y++){
                System.out.print(matriz[x][y] + "\t");
            }
            System.out.print("\n");
        }
    }

}