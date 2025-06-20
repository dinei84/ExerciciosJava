package entities;

import services.Produto;
import services.ProdutoClass;

import java.math.BigDecimal;

public class Livro extends ProdutoClass implements Produto {
    private String autor;

    public Livro(String nome, Float preco, String autor) {
        super(nome, preco);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public Float getPreco() {
        return preco;
    }

    @Override
    public String getNome() {
        return nome;
    }
}
