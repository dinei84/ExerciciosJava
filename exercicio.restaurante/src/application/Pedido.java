package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.StatusPedido;

public class Pedido {
    private Date momento;
    private StatusPedido status;
    private Cliente cliente;

    private List<ItemPedido> itemPedido = new ArrayList<>();

    public Pedido(){        
    }

    public Pedido(Date momento, StatusPedido status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItemPedido(ItemPedido item){
        itemPedido.add(item);
    }

    public void deleteItemPedido(ItemPedido item){
        itemPedido.remove(item);
    }

    public double total(){
        double soma = 0;
        for (ItemPedido item : itemPedido) {
            soma += item.subTotal();
        }
        return soma;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Pedido: ");
        str.append("Data: " + momento);
        str.append("Status: " + status);
        str.append("Cliente: " + cliente);
        for (ItemPedido item : itemPedido) {
            str.append(item.toString());
        }
        return str.toString();
    }

}
