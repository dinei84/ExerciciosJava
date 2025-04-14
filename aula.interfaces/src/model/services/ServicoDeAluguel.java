package model.services;

import model.entities.AluguelVeiculo;
import model.entities.Fatura;

import java.time.Duration;

public class ServicoDeAluguel {
    private Double precoPorDia;
    private Double precoPorHora;

    private ServicosTaxas servicosTaxas;

    public ServicoDeAluguel(Double precoPorDia, Double precoPorHora, ServicosTaxas servicosTaxas) {
        this.precoPorDia = precoPorDia;
        this.precoPorHora = precoPorHora;
        this.servicosTaxas = servicosTaxas;
    }

    public void processarFatura (AluguelVeiculo aluguelVeiculo){
        double minutos = Duration.between(aluguelVeiculo.getInicio(),aluguelVeiculo.getFim()).toMinutes();
        double horas = minutos / 60.0;

        double pagBasico;
        if (horas <= 12){
            pagBasico = precoPorHora * Math.ceil(horas);
        }else{
            pagBasico = precoPorDia * Math.ceil(horas / 24.0);
        }

        double taxas = servicosTaxas.taxa(pagBasico);

        aluguelVeiculo.setFatura(new Fatura(pagBasico, taxas));
    }

}
