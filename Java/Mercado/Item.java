package Mercado;

public class Item {
    public int quantidade;
    public Produto produto;

    public Item(int quantidade, Produto produto){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public int getQuantidade(){
        return this.quantidade;
    }

    public double valorTotal(){
        return produto.getPreco() * this.quantidade;
    }
}
