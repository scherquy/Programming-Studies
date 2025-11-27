package TP2.Testes;

import TP2.Grafos.*;

public class TesteGrafos {

    public static void main(String[] args) {

        System.out.println("===== TESTE GRAFO LISTA (NÃO ORIENTADO) =====");
        GrafoListaAdj g1 = new GrafoListaAdj(4);
        g1.addArestasNaoDirecionadas(0, 1, 5);
        g1.addArestasNaoDirecionadas(0, 2, 3);
        g1.imprime();

        System.out.println("Vizinhos de 0: " + g1.vizinhos(0));
        System.out.println("Peso(0,1) = " + g1.peso(0,1));
        System.out.println("Orientado? " + g1.ehOrientado());

        System.out.println("\n===== TESTE DIGRAFO LISTA (ORIENTADO) =====");
        DigrafoListaAdj d1 = new DigrafoListaAdj(4);
        d1.addAresta(0, 1, 10);
        d1.addAresta(1, 2, 20);
        d1.imprime();

        System.out.println("Vizinhos de 1: " + d1.vizinhos(1));
        System.out.println("Peso(1,2) = " + d1.peso(1,2));
        System.out.println("Orientado? " + d1.ehOrientado());

        System.out.println("\n===== TESTE GRAFO MATRIZ (NÃO ORIENTADO) =====");
        GrafoMatrizAdj g2 = new GrafoMatrizAdj(3);
        g2.addArestaNaoDirecionada(0, 2, 7);
        g2.imprime();

        System.out.println("Vizinhos de 0: " + g2.vizinhos(0));
        System.out.println("Peso(0,2) = " + g2.peso(0,2));

        System.out.println("\n===== TESTE DIGRAFO MATRIZ (ORIENTADO) =====");
        DigrafoMatrizAdj d2 = new DigrafoMatrizAdj(3);
        d2.addAresta(1, 2, 15);
        d2.imprime();

        System.out.println("Vizinhos de 1: " + d2.vizinhos(1));
        System.out.println("Peso(1,2) = " + d2.peso(1,2));
    }
}
