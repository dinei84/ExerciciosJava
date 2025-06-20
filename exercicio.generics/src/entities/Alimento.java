package entities;

import services.ProdutoClass;
import services.ProdutoClass;

import java.math.BigDecimal;
import java.util.Date;

public class Alimento extends ProdutoClass {
    private final Date validade;

    public Alimento(String nome, BigDecimal preco, Date validade) {
        super(nome, preco);
        this.validade = validade;
    }

    public Date getValidade() {
        return validade;
    }
}