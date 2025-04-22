package model.entities;

import java.util.Date;

public class Parcela {
    private Date dataVencimento;
    private Double valor;

    public Parcela(Date dataVencimento, Double valor){
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }


    public Double getValor() {
        return valor;
    }


    @Override
    public String toString() {
        return "Parcela: " +
                "\nData do Vencimento: " + dataVencimento +
                "\nValor: " + valor +
                "\n---------------------------------------";
    }
}
