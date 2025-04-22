package model.services;

public interface ServicoDePagamentoOnLine {
    public Double taxaDePagamento(Double quantia);
    public Double juros(Double quantia, Integer meses);
}
