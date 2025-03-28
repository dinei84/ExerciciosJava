package entities;

public class FuncionarioTerceirizado extends Funcionario{
    private Double despesasAdicionais;

    public FuncionarioTerceirizado(Double despesasAdicionais) {
        this.despesasAdicionais = despesasAdicionais;
    }

    public FuncionarioTerceirizado(String nome, Double valorPorHora, Integer horas, Double despesasAdicionais) {
        super(nome, valorPorHora, horas);
        this.despesasAdicionais = despesasAdicionais;
    }

    public Double getDespesasAdicionais() {
        return despesasAdicionais;
    }

    public void setDespesasAdicionais(Double despesasAdicionais) {
        this.despesasAdicionais = despesasAdicionais;
    }

    @Override
    public Double pagamento() {
        double despesasAdicionais = getDespesasAdicionais() * 1.10;
        return super.pagamento() + despesasAdicionais;
    }
}
