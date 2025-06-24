package entities;

import services.ProdutoBase;

import java.math.BigDecimal;

public class Livro extends ProdutoBase {
    private final String autor;

    public Livro(String nome, BigDecimal preco, String autor) {
        super(nome, preco);
        this.autor = autor;
    }

    public String getAutor(){
        return autor;
    }
}
