package entities;

import services.ProdutoBase;

import java.math.BigDecimal;
import java.util.Date;

public class Alimento extends ProdutoBase {
    private final Date validade;

    public Alimento(String nome, BigDecimal preco, Date validade) {
        super(nome, preco);
        this.validade = validade;
    }

    public Date getDate(){
        return validade;
    }
}
