package services;

import java.math.BigDecimal;

public abstract class ProdutoClass implements Produto {
    private String nome;
    private BigDecimal preco;

    public void ProdutoBase(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    protected ProdutoClass(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public String getNome() {
        return nome;
    }
}