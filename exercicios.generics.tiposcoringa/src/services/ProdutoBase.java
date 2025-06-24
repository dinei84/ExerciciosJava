package services;

import java.math.BigDecimal;

public class ProdutoBase implements Produto{
    private final String nome;
    private final BigDecimal preco;

    public ProdutoBase(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public BigDecimal getPreco() {
        return null;
    }

    @Override
    public String getNome() {
        return "";
    }
}
