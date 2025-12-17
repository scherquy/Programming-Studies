package TP3;

import java.util.HashMap;
import java.util.Map;

class NodoTrieGenero {
    Map<String, Trie> generoChildren;

    public NodoTrieGenero() {

        generoChildren = new HashMap<>();
    }
}

public class GeneroTrie {
    private final NodoTrieGenero raiz;

    public GeneroTrie() {

        raiz = new NodoTrieGenero();
    }

    public void inserir(String genero, String titulo) {
        raiz.generoChildren.putIfAbsent(genero, new Trie());
        raiz.generoChildren.get(genero).inserir(titulo);
    }

    public Map<String, Trie> getGeneroChildren() {

        return raiz.generoChildren;
    }

    public Trie getGeneroTrie(String genero) {

        return raiz.generoChildren.get(genero);
    }
}