package entities;

public class Product implements Comparable<Product>{
    private String nome;
    private Double preco;

    public Product(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Product: " +
                "\nNome; " + nome + '\'' +
                "\nPreço: " + String.format("%.2f" , preco);
    }

    @Override
    public int compareTo(Product other) {
        return preco.compareTo(other.getPreco());
    }
}
