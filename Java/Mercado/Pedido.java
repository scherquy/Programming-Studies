package Mercado;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    public TipoPagamento pagamento;
    public Cliente cliente;
    public List<Item> itens;

    public Pedido(TipoPagamento pagamento, Cliente cliente){
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void setPagamento(TipoPagamento pagamento){
        this.pagamento = pagamento;
    }
    public TipoPagamento getPagamento(){
        return this.pagamento;
    }

    public void adicionarItem(Item item){
        itens.add(item);
    }

    public double valorTotalPedido(){
        double total = 0;
        for(Item item : itens){
            total += item.valorTotal();
        }

        return total;
    }
}
