package model.entities;

public class Fatura {
    private Double pagamentoBasico;
    private Double taxas;

    public Fatura(){}

    public Fatura(Double pagamentoBasico, Double taxas) {
        this.pagamentoBasico = pagamentoBasico;
        this.taxas = taxas;
    }

    public Double getTaxas() {
        return taxas;
    }

    public void setTaxas(Double taxas) {
        this.taxas = taxas;
    }

    public Double getPagamentoBasico() {
        return pagamentoBasico;
    }

    public void setPagamentoBasico(Double pagamentoBasico) {
        this.pagamentoBasico = pagamentoBasico;
    }

    public Double getTotalPayment(){
        return getPagamentoBasico() - getTaxas();
    }
}
