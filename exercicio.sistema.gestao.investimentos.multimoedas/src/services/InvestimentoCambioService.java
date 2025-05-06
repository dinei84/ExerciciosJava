import java.math.BigDecimal;

import services.ServicoDeInvestimento;
import services.ConversorDeMoeda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvestimentoCambioService implements ServicoDeInvestimento {

    private static final BigDecimal TAXA_ANUAL;
    private final BigDecimal valor;
    private final Integer meses;
    private ConversorDeMoeda conversor;









    @Override
    public BigDecimal getTaxaAnual() {
        throw new UnsupportedOperationException("Unimplemented method 'getTaxaAnual'");
    }



}
