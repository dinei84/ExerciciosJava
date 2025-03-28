package entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto{
    private Date dataDeFabricacao;
    private static final SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

    public ProdutoUsado(Date dataDeFabricacao) {
        this.dataDeFabricacao = dataDeFabricacao;
    }

    public ProdutoUsado(String nome, Double preco, String dataDeFabricacao) throws ParseException {
        super(nome, preco);
        this.dataDeFabricacao = sdt.parse(dataDeFabricacao);
    }

    @Override
    public String etiquetaDePreco(){
        return " " + nome + " (usado) R$" + preco + " (Data de fabricação: " + sdt.format(dataDeFabricacao) + ") ";
    }
}
