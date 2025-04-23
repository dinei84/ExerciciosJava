package model.entities;

public class Encomenda {
    private String nome;
    private Double peso;
    private Double distancia;

    public Encomenda(String nome, Double distancia, Double peso) {
        this.nome = nome;
        this.distancia = distancia;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
}
