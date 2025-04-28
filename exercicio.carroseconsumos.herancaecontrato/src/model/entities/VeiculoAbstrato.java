package model.entities;

import model.services.Veiculo;

public abstract class VeiculoAbstrato implements Veiculo {
    private String modelo;
    private Integer ano;

    public VeiculoAbstrato(String modelo, Integer ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
