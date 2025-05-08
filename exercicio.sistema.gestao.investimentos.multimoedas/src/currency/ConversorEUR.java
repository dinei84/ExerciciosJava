package currency;

import java.math.BigDecimal;

public class ConversorEUR implements ConversorDeMoeda{
    private static final BigDecimal COTACAO_EUR = new BigDecimal("6.40");
    private final BigDecimal valor;

    public ConversorEUR(BigDecimal valor) {
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
        return COTACAO_EUR;
    }

    @Override
    public String toString() {
        return "Conversor Euro" +
                "\nValor Total; : " + calcular();
    }
}
