package services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvestimentoFixoService implements ServicoDeInvestimento{

    private static final BigDecimal TAXA_ANUAL = new BigDecimal("0.1415");
    private final BigDecimal valor;
    private final Integer meses;

    public InvestimentoFixoService(BigDecimal valor, Integer meses) {
        if (valor == null || meses == null){
            throw new IllegalArgumentException("O valor não pode ser nulo");
        }
        if (valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("O valor precisa ser maior que 0");
        }
        if (meses <= 0 ){
            throw new IllegalArgumentException("O periodo precisa ser maior que 0");
        }

        this.valor = valor;
        this.meses = meses;

    }

    public BigDecimal getValor() {
        return valor;
    }

    public  Integer getMeses(){
        return meses;
    }

    public BigDecimal calcularInvestimentoFixo(){
        return calcularInvestimento(getValor(),getMeses());
    }

    @Override
    public BigDecimal getTaxaAnual() {
        return TAXA_ANUAL;
    }

    @Override
    public BigDecimal calcularInvestimento(BigDecimal valor, Integer meses){
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
