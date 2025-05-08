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
    public BigDecimal calcularInvestimento(BigDecimal valor, Integer meses) {
        try {
            BigDecimal fatorJuros = null;
            if (meses <= 120 || meses > 0) {
                BigDecimal taxaMensal = getTaxaAnual()
                        .divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_EVEN);

                fatorJuros = BigDecimal.ONE.add(taxaMensal)
                        .pow(meses);
            }
            return valor.multiply(fatorJuros)
                    .setScale(2, RoundingMode.HALF_EVEN);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String  toString() {
        BigDecimal taxaConvertida = TAXA_ANUAL.multiply(new BigDecimal("100"));
        return "\nInvestimento de Juros Fixos: " +
                "\nCom Juros fixos de: " + taxaConvertida.setScale(2,RoundingMode.HALF_EVEN) + "%, anuais" +
                "\nValor inicial: R$" + valor + ",00" +
                "\nPeríodo: " + meses + ", meses";
    }
}
