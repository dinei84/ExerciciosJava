package entities;

import services.Produto;
import services.ProdutoClass;

import java.math.BigDecimal;

public class Livro extends ProdutoClass implements Produto {
    private String autor;

    public Livro(String nome, BigDecimal preco, String autor) {
        super(nome, preco);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
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
