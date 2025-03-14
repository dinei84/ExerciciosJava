package application;

import enums.StatusPedido;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double precoUnit;
    private StatusPedido status;

    public ItemPedido(){        
    }

    public ItemPedido(Produto produto, int quantidade, double precoUnit, StatusPedido status) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {    
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }  



    public double subTotal(){
        return precoUnit * quantidade;
    }

    

}
