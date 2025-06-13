package services;

import java.math.BigDecimal;

public abstract class ProdutoClass {
    protected String nome;
    protected BigDecimal preco;

    public ProdutoClass(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
