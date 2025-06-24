package entities;

import services.ProdutoClass;
import services.ProdutoClass;

import java.math.BigDecimal;

public class Livro extends ProdutoClass {
    private final String autor;

    public Livro(String nome, BigDecimal preco, String autor) {
        super(nome, preco);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }
}