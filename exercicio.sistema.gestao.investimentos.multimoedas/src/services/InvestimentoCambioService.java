package services;

import currency.ConversorDeMoeda;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
        BigDecimal montanteConvertido = conversor.calcularCambio(montanteFinal, conversor.getCotacao());
        return montanteConvertido;
    }

    public String converterTaxa(){
        BigDecimal resultado  = TAXA_ANUAL.multiply(new BigDecimal("100").setScale(2, RoundingMode.HALF_UP
        ));
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(resultado);
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
                "\nValor investido: R$" + valor + ",00" +
                "\nPeríodo: " + meses + " meses" +
                "\nTaxa de Cambio: " + converterTaxa() + "%";
    }
}
