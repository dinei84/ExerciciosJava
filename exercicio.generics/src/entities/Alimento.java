package entities;

import services.Produto;
import services.ProdutoClass;

import java.math.BigDecimal;
import java.util.Date;

public class Alimento extends ProdutoClass implements Produto {
    private Date validade;

    public Alimento(String nome, BigDecimal preco, Date validade) {
        super(nome, preco);
        this.validade = validade;
    }

    public Date getValidade() {
        return validade;
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
