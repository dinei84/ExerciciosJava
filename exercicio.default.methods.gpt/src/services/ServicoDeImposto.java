package services;

import java.security.InvalidParameterException;

public interface ServicoDeImposto {
    double getTaxas();

    default double calcular(double valor, int meses){
        if (valor <= 0){
            throw new InvalidParameterException("O valor deve ser maior do que 0");
        }
        if (meses < 1){
            throw new InvalidParameterException("os meses tem que ser maior do que 1");
        }
        return valor * Math.pow(1.0 + getTaxas() / 100.0, meses);
    }
}
