package entities;

import services.Produto;
import services.ProdutoClass;

import java.math.BigDecimal;

public class Eletronico extends ProdutoClass implements Produto {
    private String marca;

    public Eletronico(String nome, Float preco, String marca) {
        super(nome, preco);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
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
