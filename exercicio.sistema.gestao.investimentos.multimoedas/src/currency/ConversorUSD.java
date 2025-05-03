package currency;

import java.math.BigDecimal;

public class ConversorUSD implements ConversorDeMoeda{

    private static final BigDecimal COTACAO_USD = new BigDecimal("6.08");
    private final BigDecimal valor;

    public ConversorUSD(BigDecimal valor) {
        if (valor == null){
            throw new IllegalArgumentException("O valor não pode ser nulo");
        }
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal calcular(){
        return calcularCambio(getValor(), getCotacao());
    }

    @Override
    public BigDecimal getCotacao() {
        return COTACAO_USD;
    }

    @Override
    public String toString() {
        return "ConversorUSD{" +
                "Cambio: " + calcular() +
                '}';
    }
}
