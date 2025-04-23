package model.services;

public class TransportadoraEconomica implements ServicoDeFrete{
    @Override
    public double calcularFrete(double peso, double distancia) {
        double valor = 5;
        return valor + (1.2 * distancia) + (1 * peso);
    }
}
