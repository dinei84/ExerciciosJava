package entities;

import services.ProdutoClass;
import services.ProdutoClass;

import java.math.BigDecimal;

public class Eletronico extends ProdutoClass {
    private final String marca;

    public Eletronico(String nome, BigDecimal preco, String marca) {
        super(nome, preco);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }
}