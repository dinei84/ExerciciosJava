package entities;

public class Carro extends Veiculo{
    private Integer quantidadePortas;

    public Carro(){
        super();
    }

    public Carro(String modelo, String marca, Integer anoFabricacao, Double precoBase, Integer diasAlugado, Integer quantidadePortas) {
        super(modelo, marca, anoFabricacao, precoBase, diasAlugado);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public double calcularAluguel(Integer diasAlugado) {
        if (quantidadePortas <= 2) {
            return precoBase * diasAlugado;
        }
        else{
            return ((precoBase * diasAlugado) * 0.10) * 10;
        }

    }

    @Override
    public String toString() {
        return "Carro{" +
                "quantidadePortas=" + quantidadePortas +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                ", precoBase=" + precoBase +
                "Preço a pagar pelo aluguel de " + diasAlugado + " é: " + calcularAluguel(diasAlugado);
    }


}
