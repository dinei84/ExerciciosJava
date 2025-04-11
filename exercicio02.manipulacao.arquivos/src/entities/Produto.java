package entities;

public class Produto {
    String nome;
    double preco;
    int quantidadeEstoque;
    int quantidadeMinima;


    public Produto(){};
    public Produto(String nome, double preco, int quantidadeEstoque, int quantidadeMinima) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinima = quantidadeMinima;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }


    public boolean precisaRepor(){
        return quantidadeEstoque < quantidadeMinima;
    }

    public int calcularReposicao() {
        return quantidadeMinima - quantidadeEstoque;
    }


}
