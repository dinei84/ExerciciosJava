package model.services;

public class ServicoPaypal implements ServicoDePagamentoOnLine{
    @Override
    public Double taxaDePagamento(Double quantia) {
        return quantia * 0.02;

    }

    @Override
    public Double juros(Double quantia, Integer meses) {
        while (meses > 0) {
            quantia += quantia * 0.01;
            meses--;
        }
        return quantia;
    }
}
