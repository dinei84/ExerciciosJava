package model.services;

import model.entities.VeiculoAbstrato;

public class Carro extends VeiculoAbstrato {
    private Double consumoHurbano;
    private Double consumoRodoviario;
    private Double kmInicial;
    private Double kmFinal;
    private Double litrosAbastecidos;

    public Carro(String modelo, Integer ano, Double consumoHurbano, Double consumoRodoviario, Double kmInicial, Double kmFinal, Double litrosAbastecidos) {
        super(modelo, ano);
        this.consumoHurbano = consumoHurbano;
        this.consumoRodoviario = consumoRodoviario;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.litrosAbastecidos = litrosAbastecidos;
    }

    public Double getConsumoHurbano() {
        return consumoHurbano;
    }

    public void setConsumoHurbano(Double consumoHurbano) {
        this.consumoHurbano = consumoHurbano;
    }

    public Double getConsumoRodoviario() {
        return consumoRodoviario;
    }

    public void setConsumoRodoviario(Double consumoRodoviario) {
        this.consumoRodoviario = consumoRodoviario;
    }

    public Double getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(Double kmFinal) {
        this.kmFinal = kmFinal;
    }

    public Double getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(Double kmInicial) {
        this.kmInicial = kmInicial;
    }

    public Double getLitrosAbastecidos() {
        return litrosAbastecidos;
    }

    public void setLitrosAbastecidos(Double litrosAbastecidos) {
        this.litrosAbastecidos = litrosAbastecidos;
    }

    @Override
    public double calcularConsumo() {
        return consumoRodoviario = (kmInicial - kmFinal) / litrosAbastecidos;
    }
}
