package entities;

public class Funcionario {
    protected String nome;
    protected Integer horas;
    protected Double valorPorHora;

    public Funcionario(){

    }
    public Funcionario(String nome, Double valorPorHora, Integer horas) {
        this.nome = nome;
        this.valorPorHora = valorPorHora;
        this.horas = horas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }


    public Double pagamento(){
        return  getHoras() * getValorPorHora();
    }

    @Override
    public String toString() {
        return "Funcionario " +
                "\nNome: " + nome + '\'' +
                "\nHoras: " + horas +
                "\nValorPorHora: " + valorPorHora +
                "\nValor das horas trabalhadas: R$" + pagamento();
    }
}
