package entities;

import services.ProdutoBase;

import java.math.BigDecimal;

public class Eletronicos extends ProdutoBase {
    private final String marca;

    public Eletronicos(String nome, BigDecimal preco, String marca) {
        super(nome, preco);
        this.marca = marca;
    }

    public String getMarca(){
        return marca;
    }
}
