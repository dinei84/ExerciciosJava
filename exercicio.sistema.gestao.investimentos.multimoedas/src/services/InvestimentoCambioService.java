package services;

import currency.ConversorDeMoeda;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvestimentoCambioService implements ServicoDeInvestimento {

    private static final BigDecimal TAXA_ANUAL = new BigDecimal("0.0425");
    private final BigDecimal valor;
    private final Integer meses;
    private ConversorDeMoeda conversor;


    public InvestimentoCambioService(BigDecimal valor, Integer meses, ConversorDeMoeda conversor) {
        this.valor = valor;
        this.meses = meses;
        this.conversor = conversor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getMeses() {
        return meses;
    }

    public ConversorDeMoeda getConversor() {
        return conversor;
    }

    public BigDecimal calcularInvestimentoCambio(){
        BigDecimal montanteFinal = calcularInvestimento(getValor(), getMeses());
        BigDecimal montanteConvertido = conversor.calcularCambio(montanteFinal, BigDecimal.valueOf(meses));
        return montanteConvertido;
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
            throw new IllegalArgumentException("Os valores não podem ser menores que 0");
        }

        BigDecimal taxaMensal = getTaxaAnual()
                .divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_EVEN);

        BigDecimal fatorJuros = BigDecimal.ONE.add(taxaMensal)
                .pow(meses);

        return valor.multiply(fatorJuros)
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String toString() {
        return "Investimento Cambio" +
                "\nValor: " + valor +
                "\nPeríodo: " + meses +
                "\nTaxa de Cambio: " + getTaxaAnual();
    }
}
