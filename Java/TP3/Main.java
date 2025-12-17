package TP3;

import TP3.*;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GeneroTrie generoTrie = new GeneroTrie(); //cria uma instancia de GeneroTrie

        // Carregar dados de músicas a partir de um arquivo CSV
        carregarArquivo("TP3/music_data.csv", generoTrie);

        // Menu do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.println("//////////////////////////////////");
        System.out.println("   SISTEMA DE BUSCA DE MÚSICAS   ");
        System.out.println("==================================");
        System.out.println("Busque músicas por GÊNERO e PREFIXO");
        System.out.println();

        System.out.println("Digite um gênero musical (ex: rock, pop, jazz) ou 'sair' para encerrar:");
        while (true) {
            System.out.print("Gênero: ");
            String genero = scanner.nextLine().trim().toLowerCase(); //converte pra minúscula e remove espaços em branco

            if (genero.equals("sair")) {
                System.out.println("\nObrigada por usar o sistema de busca musical!");
                break;
            }

            Trie generoEspecificoTrie = generoTrie.getGeneroTrie(genero); //Pega a Trie do gênero informado
            if (generoEspecificoTrie == null) {
                System.out.println("Gênero não encontrado: " + genero);
                System.out.println("Gêneros disponíveis:");  //mostra os gêneros disponíveis pra busca
                for (String g : generoTrie.getGeneroChildren().keySet()) {
                    System.out.println("- " + g);
                }
                continue;
            }

            System.out.print("Digite um prefixo para buscar músicas: ");
            String prefixo = scanner.nextLine().trim().toLowerCase();

            List<String> sugestoes = generoEspecificoTrie.busca(prefixo);
            if (sugestoes.isEmpty()) {
                System.out.println("Nenhuma sugestão encontrada. Tente novamente ->");
            } else {
                System.out.println("\nMúsicas encontradas:");
                for (int i = 0; i < sugestoes.size(); i++) {
                    System.out.println((i + 1) + " - " + sugestoes.get(i));
                }

                System.out.print("\nDigite o número da música para buscar no YouTube (0 para cancelar): ");
                int escolha = scanner.nextInt();
                scanner.nextLine(); // limpa buffer

                if (escolha > 0 && escolha <= sugestoes.size()) {
                    String musicaEscolhida = sugestoes.get(escolha - 1);

                    // Gera o link
                    String musicaFormatada = musicaEscolhida.replace(" ", "+"); //replace substitui o espaço em branco por "+"
                    String linkYoutube = "https://www.youtube.com/results?search_query=" + musicaFormatada; //forma o link completo

                    System.out.println("Link do Youtube:");
                    System.out.println(linkYoutube);
                }
            }
        }
        scanner.close();
    }

    private static void carregarArquivo(String filePath, GeneroTrie generoTrie) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] parts = linha.split(",");
                if (parts.length == 2) {
                    String genero = parts[0].trim().toLowerCase(); //converte genero pra minuscula
                    String titulo = parts[1].trim().toLowerCase(); //converte titulo/musica pra minuscula
                    generoTrie.inserir(genero, titulo); //insere genero e titulo na árvore
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: ");
        }
    }
}