package model.services;

import model.entities.Contrato;

public class ServicoContrato {

    private Contrato contrato;
    private ServicoDePagamentoOnLine servico;

    public ServicoContrato(Contrato contrato, ServicoDePagamentoOnLine servico) {
        this.contrato = contrato;
        this.servico = servico;
    }

    public void processandoContrato(Contrato contrato, Integer meses){

    }
}
