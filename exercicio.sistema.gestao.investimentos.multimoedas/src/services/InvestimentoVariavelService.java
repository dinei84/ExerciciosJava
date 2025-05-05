package services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvestimentoVariavelService implements ServicoDeInvestimento{

    private final BigDecimal valor;
    private final Integer meses;
    private final BigDecimal TAXA_ANUAL;

    public InvestimentoVariavelService(BigDecimal valor, Integer meses, BigDecimal taxaAnual) {
        this.valor = valor;
        this.meses = meses;
        TAXA_ANUAL = taxaAnual;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getMeses() {
        return meses;
    }

    @Override
    public BigDecimal getTaxaAnual() {
        return TAXA_ANUAL;
    }

    @Override
    public BigDecimal calcularInvestimento(BigDecimal valor, Integer meses) {
        if (valor == null || meses == null){
            throw new IllegalArgumentException("Os valores não podem ser nulos");
        }
        if (valor.compareTo(BigDecimal.ZERO) <= 0 || meses <= 0){
            throw new IllegalArgumentException("Os valores precisam ser maiores que 0");
        }

        BigDecimal taxaMensal = getTaxaAnual()
                .divide(BigDecimal.valueOf(getMeses()), 10, RoundingMode.HALF_EVEN);

        BigDecimal fatorJuros = BigDecimal.ONE.add(taxaMensal)
                .pow(meses);

        return valor.multiply(fatorJuros)
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}
