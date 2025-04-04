package entities;

public abstract class Veiculo {
    protected String modelo;
    protected String marca;
    protected Integer anoFabricacao;
    protected Double precoBase;

    public Veiculo(){}

    public Veiculo(String modelo, String marca, Integer anoFabricacao, Double precoBase) {
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.precoBase = precoBase;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }


    public abstract double calcularAluguel (Integer diasAlugado);

    @Override
    public String toString() {
        return "Veiculo: " +
                "\nModelo: " + modelo +
                "\nMarca: " + marca +
                "\nAnoFabricacao: " + anoFabricacao +
                "\nPrecoBase: " + precoBase +
                "\n ----------------------------";
    }
}
