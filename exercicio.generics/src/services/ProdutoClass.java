package services;

import java.math.BigDecimal;

public abstract class ProdutoClass {
    protected String nome;
    protected Float preco;

    public ProdutoClass(String nome, Float preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
