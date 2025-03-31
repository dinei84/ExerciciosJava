package entities;

public class PessoaFisica extends Pessoa{
    private Double gastosSaude;


    public PessoaFisica(){
        super();
    }
    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double calcularImposto() {
        return Math.max ((getRendaAnual() < 20000.00 ? getRendaAnual() * 0.15 : getRendaAnual() * 0.25) - (getGastosSaude() * 0.5),0);
    }
}
