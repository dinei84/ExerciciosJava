package entities;

public abstract class Veiculo {
    protected String modelo;
    protected String marca;
    protected Integer anoFabricacao;
    protected Double precoBase;
    protected Integer diasAlugado;

    public Veiculo(){}

    public Veiculo(String modelo, String marca, Integer anoFabricacao, Double precoBase, Integer diasAlugado) {
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.precoBase = precoBase;
        this.diasAlugado = diasAlugado;
    }

    public abstract double calcularAluguel (Integer diasAlugado);


}
