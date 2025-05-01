package services;

public class ServicoImpostoEuropa implements ServicoDeImposto{
    private double taxas;

    public ServicoImpostoEuropa() {
        this.taxas = 1.2;
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
