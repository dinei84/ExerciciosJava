package model.services;

import model.entities.AluguelVeiculo;
import model.entities.Fatura;

public class ServicoDeAluguel {
    private Double precoPorDia;
    private Double precoPorHora;

    private BrasilTaxas taxasBrasil;

    public ServicoDeAluguel(Double precoPorDia, Double precoPorHora, BrasilTaxas taxasBrasil) {
        this.precoPorDia = precoPorDia;
        this.precoPorHora = precoPorHora;
        this.taxasBrasil = taxasBrasil;
    }

    public void processarFatura (AluguelVeiculo aluguelVeiculo){

        aluguelVeiculo.setFatura(new Fatura(50.0, 10.0));
    }

}
