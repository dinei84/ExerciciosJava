package model.services;

public class TransportadoraRapida implements ServicoDeFrete{
    @Override
    public double calcularFrete(double peso, double distancia) {
         double valor = 10.0;
        return valor + (2 * distancia) + (1.5 * peso);
    }
}
