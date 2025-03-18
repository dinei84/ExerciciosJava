package entities;

public class Caminhao {
    private String placa;
    private String tipo;
    private Double capacidade;

    public Caminhao(){

    }

    public Caminhao(String placa, String tipo, Double capacidade) {
        this.placa = placa;
        this.tipo = tipo;
        this.capacidade = capacidade;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Double capacidade) {
        this.capacidade = capacidade;
    }

    
}
