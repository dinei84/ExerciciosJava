package model.services;

public interface ServicoPagamentoOnLine {
    public Double taxaDePagamento(Double quantia);
    public Double juros(Double quantia, Integer meses);

}
