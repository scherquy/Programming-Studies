package TP3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNodo {
    Map<Character, TrieNodo> children;
    boolean fimDaPalavra;

    public TrieNodo() {
        children = new HashMap<>();
        fimDaPalavra = false;
    }
}

public class Trie {
    private final TrieNodo raiz;

    public Trie() {

        raiz = new TrieNodo(); 
    }

    public void inserir(String palavra) {
        TrieNodo nodo = raiz; //inicia no topo
        for (char ch : palavra.toCharArray()) { //percorre todas as letras da palavra
            nodo.children.putIfAbsent(ch, new TrieNodo());//se o caminho para a letra não existir, ele cria
            nodo = nodo.children.get(ch);//avança para o proximo nó
        }
        nodo.fimDaPalavra = true;//musica foi escrita por ecompleto
    }

    public List<String> busca(String prefixo) {
        TrieNodo nodo = raiz; //comeca na raiz
        for (char ch : prefixo.toCharArray()) { //percorre o que o usuario digitou
            if (!nodo.children.containsKey(ch)) { //se o usuario digital algo que não existe, retorna null
                return new ArrayList<>();
            }
            nodo = nodo.children.get(ch); //se existe vai para o proximo nó
        }
        return getPalavrasDoNodo(nodo, prefixo); // chama a função de autocomplete
    }

    private List<String> getPalavrasDoNodo(TrieNodo nodo, String prefixo) {
        List<String> palavras = new ArrayList<>(); //lista para guardar as musicas
        if (nodo.fimDaPalavra) { //se a musica estiver completa vai para a lista
            palavras.add(prefixo);
        }
        for (Map.Entry<Character, TrieNodo> entry : nodo.children.entrySet()) {//passa pelas ramificacoes do no atual
            palavras.addAll(getPalavrasDoNodo(entry.getValue(), prefixo + entry.getKey()));//passa pelos caminhos abaixo do que foi digitado
        }
        return palavras; //retorna as sugestões
    }
}