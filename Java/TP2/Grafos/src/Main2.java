package TP2.Grafos.src;

import java.util.Scanner;

public class Main2 {
    private static Graph grafoCarregado = null;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        do {
            System.out.println("\n.............Menu.............");
            System.out.println("1. Carregar grafo de arquivo");
            System.out.println("2. Executar Dijkstra");
            System.out.println("3. Executar Bellman-Ford");
            System.out.println("4. Executar BFS (Busca em Largura)");
            System.out.println("5. Executar DFS (Busca em Profundidade)");
            System.out.println("6. Executar Ordenação Topológica");
            System.out.println("7. Executar Prim");
            System.out.println("8. Executar Floyd-Warshall");
            System.out.println("9. Executar Kruskal");
            System.out.println("10.Executar Ford-Fulkerson");
            System.out.println("11. Imprimir grafo carregado");
            System.out.println("12. Executar Benchmark (rodar arquivos .gr e salvar tempos)");
            System.out.println("13. Informações do dígrafo");
            System.out.println("0. Sair");
            System.out.print("Selecione um número: ");
            op = sc.nextInt();
            switch (op) {
                case 1 -> carregarGrafo();
                case 2 -> executarDijkstra();
                case 3 -> executarBellmanFord();
                case 4 -> executarBFS();
                case 5 -> executarDFS();
                case 6 -> executarTopological();
                case 7 -> executarPrim();
                case 8 -> executarFloydWarshall();
                case 9 -> executarKruskal();
                case 10 -> executarFordFulkerson();
                case 11 -> imprimirGrafo();
                case 12 -> executarBenchmark();
                case 13 -> executarDigraphInfo();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private static void carregarGrafo() {
        System.out.print("Caminho do arquivo do grafo (.gr): ");
        String caminho = sc.next();
        // Escolha da representação
        System.out.print("Usar lista de adjacência? (s/n): ");
        char c = sc.next().charAt(0);
        boolean lista = (c == 's' || c == 'S');
        grafoCarregado = GTGraphReader.lerGrafo(caminho, lista);
        if (grafoCarregado != null) {
            System.out.println("Grafo carregado com sucesso.");
        } else {
            System.out.println("Falha ao carregar o grafo.");
        }
    }

    private static void executarDijkstra() {
        if (grafoCarregado == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }
        System.out.print("Vértice de origem: ");
        int s = sc.nextInt();
        s = s;
        // Executa conforme tipo de grafo carregado
        if (grafoCarregado instanceof AdjListGraph) {
            int[] dist =
                    Dijkstra.dijkstraLista((AdjListGraph)grafoCarregado, s);
            System.out.println("Distâncias mínimas (Dijkstra - Lista):");
            for (int i = 0; i < dist.length; i++) {
                System.out.println("origem->" + i + " = " + dist[i]);
            }
        } else if (grafoCarregado instanceof AdjMatrixGraph) {
            int[] dist =
                    Dijkstra.dijkstraMatriz((AdjMatrixGraph)grafoCarregado, s);
            System.out.println("Distâncias mínimas (Dijkstra - Matriz):");
            for (int i = 0; i < dist.length; i++) {
                System.out.println("origem->" + i + " = " + dist[i]);
            }
        } else {
            System.out.println("Grafo desconhecido.");
        }
    }

    private static void executarBellmanFord() {
        if (grafoCarregado == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }
        System.out.print("Vértice de origem: ");
        int s = sc.nextInt();
        s = s; // ajuste de índice, se necessário
        if (grafoCarregado instanceof AdjListGraph) {
            int[] dist =
                    BellmanFord.bellmanFordLista((AdjListGraph)grafoCarregado, s);
            System.out.println("Distâncias mínimas (Bellman-Ford - Lista):");
            for (int i = 0; i < dist.length; i++) {
                System.out.println("origem->" + i + " = " + dist[i]);
            }
        } else if (grafoCarregado instanceof AdjMatrixGraph) {
            int[] dist =
                    BellmanFord.bellmanFordMatriz((AdjMatrixGraph)grafoCarregado, s);
            System.out.println("Distâncias mínimas (Bellman-Ford - Matriz):");
            for (int i = 0; i < dist.length; i++) {
                System.out.println("origem->" + i + " = " + dist[i]);
            }
        } else {
            System.out.println("Grafo desconhecido.");
        }
    }

    private static void imprimirGrafo() {
        GraphWriter.escreverGrafo(grafoCarregado);
    }

    private static void executarBenchmark() {
        System.out.println("Iniciando execução de benchmark...");
        ExperimentRunner.executarExperimento();
    }

    private static void executarBFS() {
        if (grafoCarregado == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }
        System.out.print("Vértice de origem para BFS: ");
        int s = sc.nextInt();
        int n = grafoCarregado.numeroVertices();
        if (s < 0 || s >= n) {
            System.out.println("Vértice de origem inválido: " + s);
            return;
        }

        BFS.executar(grafoCarregado, s);
    }

    private static void executarDFS() {
        if (grafoCarregado == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }
        System.out.print("Vértice de origem para DFS: ");
        int s = sc.nextInt();
        int n = grafoCarregado.numeroVertices();
        if (s < 0 || s >= n) {
            System.out.println("Vértice de origem inválido: " + s);
            return;
        }

        DFS.executar(grafoCarregado, s);
    }

    private static void executarTopological() {
        if (grafoCarregado == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }
        OrdTopologica.executar(grafoCarregado);
    }


    private static void executarPrim() {
        if (grafoCarregado == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }

        if (grafoCarregado instanceof AdjListGraph lista) {
            Prim.executar(lista);
        } else {
            System.out.println("Prim está implementado somente para lista de adjacência.");
        }
    }


    private static void executarFloydWarshall() {
        if (grafoCarregado == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }
        if (grafoCarregado instanceof AdjMatrixGraph matriz) {
            FloydWharshall.executar(matriz);
        } else {
            System.out.println("Floyd-Warshall requer grafo em matriz de adjacência.");
        }
    }


    private static void executarDigraphInfo() {
        if (grafoCarregado == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }

        Digraph.verificarDirecionamento(grafoCarregado);
        Digraph.topologicalSort(grafoCarregado);
    }


    private static void executarKruskal() {
        if (grafoCarregado == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }
        if (grafoCarregado.isDirecionado()) {
            System.out.println("Kruskal exige grafo NÃO direcionado.");
            return;
        }
        Kruskal.executar(grafoCarregado);
    }

    private static void executarFordFulkerson() {
        if (grafoCarregado == null) {
            System.out.println("Nenhum grafo carregado.");
            return;
        }

        if (!grafoCarregado.isDirecionado()) {
            System.out.println("Ford–Fulkerson requer grafo direcionado.");
            return;
        }

        System.out.print("Vértice de origem (s): ");
        int s = sc.nextInt();

        System.out.print("Vértice de destino (t): ");
        int t = sc.nextInt();

        FordFulkerson.executar(grafoCarregado, s, t);
    }

}
