package services;

import java.math.BigDecimal;

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
        if (meses < 1 ){
            throw new IllegalArgumentException("O periodo precisa ser maior que 0");
        }

        this.valor = valor;
        this.meses = meses;

    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal calcularInvestimentoFixo(){
        return calcularInvestimento(getValor(),meses);
    }

    @Override
    public BigDecimal getTaxaAnual() {
        return TAXA_ANUAL;
    }
}
