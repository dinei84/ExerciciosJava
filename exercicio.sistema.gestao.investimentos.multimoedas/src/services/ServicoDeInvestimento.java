package services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface ServicoDeInvestimento {

    BigDecimal getTaxaAnual();

    default BigDecimal calcularInvestimento(BigDecimal valor, Integer meses){
        if (valor == null || meses == null){
            throw new IllegalArgumentException("Os valores não podem ser nulos");
        }
        if (valor.compareTo(BigDecimal.ZERO) <= 0 || meses <= 0){
            throw new IllegalArgumentException("Os valores precisam ser maiores que 0");
        }

        BigDecimal taxaMensal = getTaxaAnual()
                .divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_EVEN);

        BigDecimal fatorJuros = BigDecimal.ONE.add(taxaMensal)
                .pow(meses);

        return valor.multiply(fatorJuros)
                .setScale(2, RoundingMode.HALF_EVEN);
    }


}
