package services;

import java.security.InvalidParameterException;

public interface ServicoDeFrete {
    double getTaxasPorKg();

    default double calcular(double peso, double valorSeguro){
        if (peso <= 0) {
            throw new InvalidParameterException("O peso deve ser maior que 0");
        }

        return peso * getTaxasPorKg() + valorSeguro;
    }


    
}
