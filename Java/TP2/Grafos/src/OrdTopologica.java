package TP2.Grafos.src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class OrdTopologica {

    public static void executar(Graph g) {
        if (g == null) {
            System.out.println("Nenhum grafo fornecido para ordenação topológica.");
            return;
        }

        if (!g.isDirecionado()) {
            System.out.println("Ordenação topológica só é aplicável a grafos direcionados.");
            return;
        }

        int n = g.numeroVertices();

        // Cronômetro inicia aqui
        Stopwatch sw = new Stopwatch();
        sw.iniciar();

        // Calcula grau de entrada (indegree)
        int[] indegree = new int[n];
        Arrays.fill(indegree, 0);
        for (int u = 0; u < n; u++) {
            for (Edge e : g.obterAdjacentes(u)) {
                int v = e.getDestino();
                indegree[v]++;
            }
        }

        // Fila com vértices de indegree 0
        Queue<Integer> fila = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) fila.add(i);
        }

        List<Integer> ordenacao = new ArrayList<>();

        while (!fila.isEmpty()) {
            int u = fila.poll();
            ordenacao.add(u);
            for (Edge e : g.obterAdjacentes(u)) {
                int v = e.getDestino();
                indegree[v]--;
                if (indegree[v] == 0) {
                    fila.add(v);
                }
            }
        }

        boolean sucesso = (ordenacao.size() == n);

        // Imprime resultado ao usuário
        if (sucesso) {
            System.out.println("Ordenação topológica (Kahn) encontrada:");
            for (int i = 0; i < ordenacao.size(); i++) {
                System.out.print(ordenacao.get(i));
                if (i < ordenacao.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        } else {
            System.out.println("O grafo contém ciclo(s) — não existe ordenação topológica.");
        }

        double tempoMs = sw.parar();
        ResultLogger.registrar("TopologicalSort", tempoMs);

        // Gravar resultado em CSV (append). Cabeçalho se necessário.
        String csvFile = "topological.csv";
        boolean precisaCabecalho = !Files.exists(Paths.get(csvFile));
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(fmt);

        try (FileWriter fw = new FileWriter(csvFile, true);
             PrintWriter pw = new PrintWriter(fw)) {

            if (precisaCabecalho) {
                // timestamp,vertices,arestas,sucesso,tempo_ms,ordenacao
                pw.println("timestamp,vertices,arestas,sucesso,tempo_ms,ordenacao");
            }

            // Converte ordenação para string (lista separada por ';'), ou vazio se ciclo
            String ordenacaoStr = "";
            if (sucesso) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ordenacao.size(); i++) {
                    if (i > 0) sb.append(";");
                    sb.append(ordenacao.get(i));
                }
                ordenacaoStr = sb.toString();
            } else {
                ordenacaoStr = "CICLO";
            }

            // Atenção: caso ordenacaoStr seja muito grande, ainda assim gravamos — é só um CSV de experimento.
            pw.printf("%s,%d,%d,%b,%.3f,%s%n",
                    timestamp, g.numeroVertices(), g.numeroArestas(), sucesso, tempoMs, ordenacaoStr);
            pw.flush();
        } catch (IOException ex) {
            System.out.println("Erro ao gravar em " + csvFile + ": " + ex.getMessage());
        }
    }
}
