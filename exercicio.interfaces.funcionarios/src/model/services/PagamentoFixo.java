package model.services;

public class PagamentoFixo implements CalculadoraDePagamento{
    private double slarioFixo;

    public PagamentoFixo(double slarioFixo) {
        this.slarioFixo = slarioFixo;
    }

    public double getSlarioFixo() {
        return slarioFixo;
    }

    public void setSlarioFixo(double slarioFixo) {
        this.slarioFixo = slarioFixo;
    }

    @Override
    public double calcularPagamento() {
        return getSlarioFixo();
    }
}
