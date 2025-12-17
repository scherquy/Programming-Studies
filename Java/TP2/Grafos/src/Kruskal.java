package TP2.Grafos.src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Kruskal {

    // ------------------------ UNION-FIND ------------------------
    private static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return false;
            if (rank[a] < rank[b]) parent[a] = b;
            else if (rank[b] < rank[a]) parent[b] = a;
            else {
                parent[b] = a;
                rank[a]++;
            }
            return true;
        }
    }

    // ------------------------ KRUSKAL ------------------------
    public static void executar(Graph g) {
        if (g == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }

        if (g.isDirecionado()) {
            System.out.println("Kruskal funciona apenas para grafos NÃO direcionados.");
            return;
        }

        int n = g.numeroVertices();

        // 1) Construir lista de arestas sem duplicação.
        List<Edge> arestas = new ArrayList<>();
        HashSet<Long> seen = new HashSet<>(); // codifica par (min,max) em long para evitar duplicatas

        if (g instanceof AdjMatrixGraph) {
            AdjMatrixGraph mg = (AdjMatrixGraph) g;
            for (int u = 0; u < n; u++) {
                for (int v = u + 1; v < n; v++) { // só u < v evita duplicatas
                    int w = mg.obterPeso(u, v);
                    if (w != -1) {
                        long code = (((long) u) << 32) | (v & 0xFFFFFFFFL);
                        if (!seen.contains(code)) {
                            seen.add(code);
                            arestas.add(new Edge(u, v, w));
                        }
                    }
                }
            }
        } else {
            // General fallback (inclui AdjListGraph e qualquer Graph que suporte obterAdjacentes)
            for (int u = 0; u < n; u++) {
                for (Edge e : g.obterAdjacentes(u)) {
                    int v = e.getDestino();
                    int a = Math.min(u, v);
                    int b = Math.max(u, v);
                    long code = (((long) a) << 32) | (b & 0xFFFFFFFFL);
                    if (!seen.contains(code)) {
                        seen.add(code);
                        arestas.add(new Edge(a, b, e.getPeso())); // normaliza origem<destino
                    }
                }
            }
        }

        if (arestas.isEmpty()) {
            System.out.println("Não há arestas no grafo.");
            return;
        }

        // 2) Ordenar por peso
        arestas.sort(Comparator.comparingInt(Edge::getPeso));

        // 3) Conta componentes (usando DFS via obterAdjacentes) para detectar desconexão
        int componentes = contarComponentes(g);
        if (componentes > 1) {
            System.out.println("Atenção: o grafo é desconexo (componentes = " + componentes + ").");
            System.out.println("Será construída a Floresta Geradora Mínima (MSF) — uma MST por componente.");
        }

        Stopwatch sw = new Stopwatch();
        sw.iniciar();

        // 4) Executa Kruskal produzindo MST ou MSF
        DSU dsu = new DSU(n);
        List<Edge> mst = new ArrayList<>();
        long pesoTotal = 0L;

        for (Edge e : arestas) {
            int u = e.getOrigem();
            int v = e.getDestino();
            int w = e.getPeso();

            if (dsu.union(u, v)) {
                mst.add(e);
                pesoTotal += w;
                // se já temos n - componentes arestas, podemos terminar:
                if (mst.size() == n - componentes) break;
            }
        }

        double tempoMs = sw.parar();
        ResultLogger.registrar("Kruskal", tempoMs);

        // ---------------------- Impressão ----------------------
        System.out.println("\nÁrvore Geradora Mínima / Floresta Geradora Mínima (Kruskal):");
        for (Edge e : mst) {
            System.out.println(e.getOrigem() + " -- " + e.getDestino() + " (peso=" + e.getPeso() + ")");
        }
        System.out.println("Peso total (soma das arestas escolhidas) = " + pesoTotal);
        System.out.println("Número de arestas na solução = " + mst.size());
        System.out.println("Tempo (ms): " + tempoMs);

        // ---------------------- CSV ----------------------------
        String csvFile = "kruskal.csv";
        boolean cab = !Files.exists(Paths.get(csvFile));
        try (FileWriter fw = new FileWriter(csvFile, true);
             PrintWriter pw = new PrintWriter(fw)) {

            if (cab) {
                pw.println("timestamp,vertices,arestas,componentes,peso_total,tempo_ms");
            }
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pw.printf("%s,%d,%d,%d,%d,%.3f%n",
                    timestamp,
                    g.numeroVertices(),
                    g.numeroArestas(),
                    componentes,
                    pesoTotal,
                    tempoMs);
        } catch (IOException ex) {
            System.out.println("Erro ao escrever kruskal.csv: " + ex.getMessage());
        }
    }

    // ---------------------- helpers ----------------------

    /**
     * Conta componentes conexas usando DFS (usa obterAdjacentes do Graph).
     */
    private static int contarComponentes(Graph g) {
        int n = g.numeroVertices();
        boolean[] vis = new boolean[n];
        int comps = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                comps++;
                // stack DFS
                Stack<Integer> st = new Stack<>();
                st.push(i);
                vis[i] = true;
                while (!st.isEmpty()) {
                    int u = st.pop();
                    for (Edge e : g.obterAdjacentes(u)) {
                        int v = e.getDestino();
                        if (!vis[v]) {
                            vis[v] = true;
                            st.push(v);
                        }
                    }
                }
            }
        }
        return comps;
    }
}
