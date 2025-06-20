package entities;

import services.Produto;
import services.ProdutoClass;

import java.math.BigDecimal;
import java.util.Date;

public class Alimento extends ProdutoClass implements Produto {
    private Date validade;

    public Alimento(String nome, float preco, Date validade) {
        super(nome, preco);
        this.validade = validade;
    }

    public Date getValidade() {
        return validade;
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
