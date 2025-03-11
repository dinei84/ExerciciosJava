package entities;

public class OrderItem {

    private Integer quantidade;
    
    private Product produto;

    public OrderItem() {
    }

    public OrderItem(Integer quantidade, Product produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Product getProduto() {
        return produto;
    }

    public void setProduto(Product produto) {
        this.produto = produto;
    }

    public Double subTotal() {
        return quantidade * produto.getPreco();
    }

}
