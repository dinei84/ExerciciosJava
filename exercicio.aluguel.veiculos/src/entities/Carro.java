package entities;

public class Carro extends Veiculo{
    private Integer quantidadePortas;


    public Carro(String modelo, String marca, Integer anoFabricacao, Double precoBase, Integer quantidadePortas) {
        super(modelo, marca, anoFabricacao, precoBase);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public double calcularAluguel(Integer diasAlugado) {
        return quantidadePortas <= 4 ? precoBase * diasAlugado : precoBase * diasAlugado * 1.1;
    }

    @Override
    public String toString() {
        return "Carro: "  +
                "\nModelo: " + modelo +
                "\nMarca: " + marca +
                "\nAnoFabricacao: " + anoFabricacao +
                "\nPrecoBase: " + precoBase +
                "\nQuantidadePortas: " + quantidadePortas +
                "\n-------------------------------------";

    }


}
