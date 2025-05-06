package services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface ServicoDeInvestimento {

    BigDecimal getTaxaAnual();

    default BigDecimal calcularInvestimento(BigDecimal valor, Integer meses){
        if (valor == null || meses == null){
            throw new IllegalArgumentException("Os valores não podem ser nulos");
        }
        return valor;
    }


}
