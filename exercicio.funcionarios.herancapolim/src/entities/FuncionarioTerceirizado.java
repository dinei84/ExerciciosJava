package entities;

public class FuncionarioTerceirizado extends Funcionario{
    private Double despesasAdicionais;

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
