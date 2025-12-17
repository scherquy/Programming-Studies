package TP2.Grafos.src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Prim {

    public static void executar(AdjListGraph g) {
        if (g == null) {
            System.out.println("Nenhum grafo fornecido para Prim.");
            return;
        }

        // Se o grafo for direcionado, convertemos para uma cópia não-direcionada
        if (g.isDirecionado()) {
            System.out.println("Aviso: grafo direcionado fornecido. Convertendo para grafo não-direcionado para Prim...");
            g = converterParaNaoDirecionado(g);
        }

        int n = g.numeroVertices();
        boolean[] visitado = new boolean[n];
        int[] chave = new int[n];
        int[] pai = new int[n];

        Arrays.fill(chave, Integer.MAX_VALUE);
        Arrays.fill(pai, -1);

        Stopwatch sw = new Stopwatch();
        sw.iniciar();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int componentes = 0;

        // Rodar Prim em cada componente desconexo (inicia um novo Prim sempre que encontra um vértice não visitado)
        for (int start = 0; start < n; start++) {
            if (visitado[start]) continue;
            // novo componente
            componentes++;
            chave[start] = 0;
            pq.add(new int[]{start, 0});

            while (!pq.isEmpty()) {
                int u = pq.poll()[0];
                if (visitado[u]) continue;
                visitado[u] = true;

                for (Edge e : g.obterAdjacentes(u)) {
                    int v = e.getDestino();
                    int w = e.getPeso();
                    if (!visitado[v] && w < chave[v]) {
                        chave[v] = w;
                        pai[v] = u;
                        pq.add(new int[]{v, w});
                    }
                }
            }
            // esvazia a fila (já vazia ao sair do while), segue para próximo componente
        }

        double tempoMs = sw.parar();
        ResultLogger.registrar("Prim", tempoMs);

        // Recolher e imprimir resultado (arestas da AGM / floresta)
        int pesoTotal = 0;
        List<String> mstArestas = new ArrayList<>();
        for (int v = 0; v < n; v++) {
            if (pai[v] != -1) {
                // encontrar peso correspondente (procura na lista de adjacência; como grafo é não-direcionado, basta procurar u->v)
                int u = pai[v];
                int peso = encontrarPeso(g, u, v);
                pesoTotal += peso;
                mstArestas.add(u + " - " + v + " (peso=" + peso + ")");
            }
        }

        System.out.println("Árvore(s) Geradora(s) Mínima(s) (Prim):");
        for (String s : mstArestas) {
            System.out.println(s);
        }
        System.out.println("Peso total (soma das arestas selecionadas): " + pesoTotal);
        System.out.println("Componentes encontrados: " + componentes);
        System.out.printf("Tempo (ms): %.3f%n", tempoMs);

        // Gravar CSV
        String csvFile = "prim.csv";
        boolean precisaCabecalho = !Files.exists(Paths.get(csvFile));
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(fmt);

        try (FileWriter fw = new FileWriter(csvFile, true);
             PrintWriter pw = new PrintWriter(fw)) {

            if (precisaCabecalho) {
                pw.println("timestamp,vertices,arestas,componentes,peso_total,tempo_ms");
            }
            pw.printf("%s,%d,%d,%d,%d,%.3f%n",
                    timestamp, g.numeroVertices(), g.numeroArestas(), componentes, pesoTotal, tempoMs);
            pw.flush();
        } catch (IOException ex) {
            System.out.println("Erro ao gravar em " + csvFile + ": " + ex.getMessage());
        }
    }

    private static int encontrarPeso(AdjListGraph g, int u, int v) {
        for (Edge e : g.obterAdjacentes(u)) {
            if (e.getDestino() == v) return e.getPeso();
        }
        // fallback: procurar no outro sentido (caso estrutura estranha)
        for (Edge e : g.obterAdjacentes(v)) {
            if (e.getDestino() == u) return e.getPeso();
        }
        return Integer.MAX_VALUE;
    }

    private static AdjListGraph converterParaNaoDirecionado(AdjListGraph g) {
        int n = g.numeroVertices();
        AdjListGraph ug = new AdjListGraph(n);
        ug.setDirecionado(false);

        HashSet<Long> seen = new HashSet<>();
        for (int u = 0; u < n; u++) {
            for (Edge e : g.obterAdjacentes(u)) {
                int v = e.getDestino();
                int a = Math.min(u, v);
                int b = Math.max(u, v);
                long code = (((long) a) << 32) | (b & 0xFFFFFFFFL);
                if (!seen.contains(code)) {
                    seen.add(code);
                    ug.adicionarAresta(a, b, e.getPeso()); // adiciona aresta (a<->b)
                }
            }
        }
        return ug;
    }
}
