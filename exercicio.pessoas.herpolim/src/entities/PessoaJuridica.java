package entities;

public class PessoaJuridica extends Pessoa{
    private Integer numeroFuncionarios;

    public PessoaJuridica(){
        super();
    }
    public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double calcularImposto() {
        return getNumeroFuncionarios() > 10 ? getRendaAnual() * 0.14 : getRendaAnual() * 0.16;
    }
}
