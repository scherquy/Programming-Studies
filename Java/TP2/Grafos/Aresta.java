package TP2.Grafos;

public class Aresta {
    public int destino;
    public int peso;

    public Aresta(int destino, int peso){
        this.destino = destino;
        this.peso = peso;
    }

    public String toString(){
        return "(" + this.destino + ", peso = " + this.peso + ")";
    }
}