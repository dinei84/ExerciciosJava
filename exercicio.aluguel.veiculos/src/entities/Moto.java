package entities;

public class Moto extends Veiculo{
    private Integer cilindrada;


    public Moto(String modelo, String marca, Integer anoFabricacao, Double precoBase, Integer cilindrada) {
        super(modelo, marca, anoFabricacao, precoBase);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularAluguel(Integer diasAlugado) {
        return cilindrada > 250 ? precoBase * diasAlugado * 1.05 : precoBase * diasAlugado;
    }

    @Override
    public String toString() {
        return "Moto: " +
                "\nModelo: " + modelo +
                "\nMarca: " + marca +
                "\nAnoFabricacao: " + anoFabricacao +
                "\nPrecoBase: " + precoBase +
                "\nCilindrada: " + cilindrada +
                "\n---------------------------------";
    }
}
