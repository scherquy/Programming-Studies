package Mercado;

public class Produto {
    public Descricao descricao;
    public double preco;
    public int quantidadeEstoque;

    public Produto(Descricao descricao, double preco, int quantidadeEstoque){
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setDescricao(Descricao descricao){
        this.descricao = descricao;
    }
    public Descricao getDescricao(){
        return this.descricao;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }
    public double getPreco(){
        return this.preco;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque){
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public int getQuantidadeEstoque(){
        return this.quantidadeEstoque;
    }

    public boolean verificarEstoque(int quantidade){
            return quantidade <= quantidadeEstoque;
    }

    public void baixarEstoque(int quantidade){
        quantidadeEstoque -= quantidade;
    }
}
