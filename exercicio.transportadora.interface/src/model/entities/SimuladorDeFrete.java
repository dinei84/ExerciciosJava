package model.entities;

import model.services.ServicoDeFrete;

public class SimuladorDeFrete {
    private ServicoDeFrete servico;
    private Encomenda encomenda;

    public SimuladorDeFrete(ServicoDeFrete servico, Encomenda encomenda) {
        this.servico = servico;
        this.encomenda = encomenda;
    }


    public void simularFrete(ServicoDeFrete servico, Encomenda encomenda){

    }
}
