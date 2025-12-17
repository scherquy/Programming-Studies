package TP2.Grafos.src;

// Cronômetro para medir tempo de execução.

public class Stopwatch {
    private long inicio;
    public void iniciar() {
        inicio = System.nanoTime();
    }
    public double parar() {
        long fim = System.nanoTime();
// retorna tempo em milissegundos
        return (fim - inicio) / 1000000.0;
    }
}
