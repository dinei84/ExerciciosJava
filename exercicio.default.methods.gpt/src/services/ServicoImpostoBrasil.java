package services;

public class ServicoImpostoBrasil implements ServicoDeImposto{
    private double taxas;

    public ServicoImpostoBrasil() {
        this.taxas = 1.8;
    }

    @Override
    public double getTaxas() {
        return taxas;
    }

    @Override
    public double calcular(double valor, int meses) {
        return ServicoDeImposto.super.calcular(valor, meses);
    }
}
