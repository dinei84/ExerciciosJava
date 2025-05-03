package currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface ConversorDeMoeda {

    BigDecimal getCotacao();


    default BigDecimal calcularCambio(BigDecimal valor, BigDecimal cotacao){
        if (valor == null || cotacao == null){
            throw new IllegalArgumentException("O valor e a cotação não podem ser nulos");
        }
        if (valor.compareTo(BigDecimal.ZERO) <= 0 || cotacao.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Os valor e a cotação precisam ser maiores que 0");
        }

        return valor.multiply(cotacao).setScale(2, RoundingMode.HALF_EVEN);

    }
}
