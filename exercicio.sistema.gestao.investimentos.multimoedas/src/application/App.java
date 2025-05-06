package application;

import currency.ConversorDeMoeda;
import currency.ConversorEUR;
import currency.ConversorUSD;
import services.InvestimentoFixoService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        BigDecimal valorInicial = new BigDecimal("5000.00");
        Integer periodoMeses = 24;

        // Criar o serviço de investimento
        InvestimentoFixoService investimento = new InvestimentoFixoService(valorInicial, periodoMeses);

        // Calcular o valor final
        BigDecimal valorFinal = investimento.calcularInvestimentoFixo();

        // Exibir resultados
        System.out.println("=== Teste de Investimento Fixo ===");
        System.out.println("Valor inicial: R$ " + valorInicial);
        System.out.println("Período: " + periodoMeses + " meses");
        System.out.println("Taxa anual: " + investimento.getTaxaAnual().multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN) + "%");
        System.out.println("Valor final: R$ " + valorFinal);

        // Calcular o rendimento
        BigDecimal rendimento = valorFinal.subtract(valorInicial);
        BigDecimal percentualRendimento = rendimento.divide(valorInicial, 4, RoundingMode.HALF_EVEN)
                .multiply(new BigDecimal("100"))
                .setScale(2, RoundingMode.HALF_EVEN);

        System.out.println("Rendimento: R$ " + rendimento + " (" + percentualRendimento + "%)");

        sc.close();
    }

}
