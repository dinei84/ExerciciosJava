package entities;

public class Moto extends Veiculo{
    private Integer cilindrada;

    public Moto(){
        super();
    }

    public Moto(String modelo, String marca, Integer anoFabricacao, Double precoBase, Integer diasAlugado, Integer cilindrada) {
        super(modelo, marca, anoFabricacao, precoBase, diasAlugado);
        this.cilindrada = cilindrada;
    }
    public Moto(String modelo, String marca, int anoFabricacao, Double precoBase, int cilindrada) {
    }



    @Override
    public double calcularAluguel(Integer diasAlugado) {
        if (cilindrada >= 250){
            return precoBase * diasAlugado * 1.1;
        }else{
            return precoBase * diasAlugado;
        }
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cilindrada=" + cilindrada +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                ", precoBase=" + precoBase +
                ",O preço a pagar pelo alugel de: " + diasAlugado + " é: " + calcularAluguel(diasAlugado) +
                '}';
    }
}
