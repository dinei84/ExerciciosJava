package model.entities;

import model.services.ServicoDeFrete;

public class SimuladorDeFrete {
    private ServicoDeFrete servico;
    private Encomenda encomenda;

    public SimuladorDeFrete(ServicoDeFrete servico, Encomenda encomenda) {
        this.servico = servico;
        this.encomenda = encomenda;
    }


    public void simularFrete(){
        double valorFrete = servico.calcularFrete(encomenda.getPeso(), encomenda.getDistancia());
        System.out.println("O valor do frete para a encomenda de: " + encomenda.getNome() + " é: R$ " + valorFrete);
    }
}
