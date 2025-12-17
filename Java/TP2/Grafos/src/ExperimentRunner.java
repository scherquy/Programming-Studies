package TP2.Grafos.src;

import java.io.FileWriter;
import java.io.IOException;

public class ExperimentRunner {

    // Mede a memória usada em bytes.

    private static long memoriaUsada() {
        Runtime rt = Runtime.getRuntime();
        rt.gc();
        return rt.totalMemory() - rt.freeMemory();
    }

    public static void executarExperimento() {

        String[] arquivos = {
                "../sample100-1980.gr", "../sample100-3960.gr", "../sample100-5940.gr",
                "../sample100-7920.gr", "../sample100-9900.gr",
                "../sample200-7960.gr", "../sample200-15920.gr", "../sample200-23880.gr",
                "../sample200-31840.gr", "../sample200-39800.gr",
                "../sample500-49900.gr", "../sample500-99800.gr", "../sample500-149700.gr",
                "../sample500-199600.gr", "../sample500-249500.gr"
        };

        System.out.println("📊 Iniciando benchmark...");

        try (FileWriter memCSV = new FileWriter("memoria.csv")) {

            memCSV.write("arquivo,representacao,memoria_bytes,memoria_kb,vertices,arestas,densidade,tipo_grafo\n");

            Stopwatch sw = new Stopwatch();

            for (String arq : arquivos) {

                System.out.println("\n=== Testando arquivo: " + arq + " ===");

                // ============================================================
                // 1️⃣ CARREGAR LISTA E MEDIR MEMÓRIA
                // ============================================================
                long antesLista = memoriaUsada();
                Graph gList = GTGraphReader.lerGrafo(arq, true);
                long depoisLista = memoriaUsada();
                long usadoLista = depoisLista - antesLista;

                int vertices = gList.numeroVertices();
                int arestas = gList.numeroArestas();

                // ---- Cálculo da densidade ----
                double densidade = (double) arestas / (vertices * (vertices - 1));

                // ---- Classificação ----
                String tipoGrafo = densidade >= 0.55 ? "denso" : "esparso";

                System.out.printf("Grafo: V=%d, E=%d, densidade=%.4f → %s\n",
                        vertices, arestas, densidade, tipoGrafo);

                memCSV.write(arq + ",lista," + usadoLista + "," +
                        (usadoLista / 1024.0) + "," +
                        vertices + "," + arestas + "," +
                        densidade + "," + tipoGrafo + "\n");

                System.out.println("Memória LISTA: " + (usadoLista / 1024) + " KB");

                // ============================================================
                // 2️⃣ CARREGAR MATRIZ E MEDIR MEMÓRIA
                // ============================================================
                long antesMatriz = memoriaUsada();
                Graph gMat = GTGraphReader.lerGrafo(arq, false);
                long depoisMatriz = memoriaUsada();
                long usadoMatriz = depoisMatriz - antesMatriz;

                memCSV.write(arq + ",matriz," + usadoMatriz + "," +
                        (usadoMatriz / 1024.0) + "," +
                        vertices + "," + arestas + "," +
                        densidade + "," + tipoGrafo + "\n");

                System.out.println("Memória MATRIZ: " + (usadoMatriz / 1024) + " KB");

              // ============================================================
// 3️⃣ TEMPOS — DIJKSTRA E BELLMAN-FORD COM DENSIDADE
// ============================================================

String tipo = densidade >= 0.55 ? "denso" : "esparso";


// --- Dijkstra Lista ---
sw.iniciar();
Dijkstra.dijkstraLista((AdjListGraph) gList, 0);
double t1 = sw.parar();
ResultLogger.registrar1("Dijkstra-lista", t1, arq, vertices, arestas, densidade, tipo);

// --- Dijkstra Matriz ---
sw.iniciar();
Dijkstra.dijkstraMatriz((AdjMatrixGraph) gMat, 0);
double t2 = sw.parar();
ResultLogger.registrar1("Dijkstra-matriz", t2, arq, vertices, arestas, densidade, tipo);

// --- Bellman-Ford Lista ---
sw.iniciar();
BellmanFord.bellmanFordLista((AdjListGraph) gList, 0);
double t3 = sw.parar();
ResultLogger.registrar1("BellmanFord-lista", t3, arq, vertices, arestas, densidade, tipo);

// --- Bellman-Ford Matriz ---
sw.iniciar();
BellmanFord.bellmanFordMatriz((AdjMatrixGraph) gMat, 0);
double t4 = sw.parar();
ResultLogger.registrar1("BellmanFord-matriz", t4, arq, vertices, arestas, densidade, tipo);

                // limpar memória
                gList = null;
                gMat = null;
                System.gc();
            }

            System.out.println("\n✔ Benchmark concluído!");
            System.out.println("📁 Arquivo de memória salvo em: memoria.csv");

        } catch (IOException e) {
            System.out.println("Erro ao escrever memoria.csv");
            e.printStackTrace();
        }
    }
}
