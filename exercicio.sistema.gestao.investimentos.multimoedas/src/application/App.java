package application;

import currency.ConversorDeMoeda;
import currency.ConversorEUR;
import currency.ConversorUSD;
import services.InvestimentoCambioService;
import services.InvestimentoFixoService;
import services.InvestimentoVariavelService;
import services.ServicoDeInvestimento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("===Bem vindo a InvestDinei====");
        System.out.println("==============================");

        System.out.println("Qual o tipo de investimento que simular:");
        System.out.print("1- Investimentos com imposto fixo / 2- Investimentos com imposto variavel / 3- Investimentos no exterior ");
        int escolha = sc.nextInt();

        System.out.print("Qual o valor do investimento: ");
        BigDecimal valor = sc.nextBigDecimal();

        System.out.print("Digite a duração, em meses do investimento: ");
        int meses = sc.nextInt();

        if (escolha == 1){
            ServicoDeInvestimento fixo = new InvestimentoFixoService(valor, meses);
            BigDecimal valorFinal = fixo.calcularInvestimento(valor, meses);
            System.out.println(fixo);
            System.out.println("Valor Final: R$" + valorFinal);
        }
        if (escolha == 2){
            System.out.print("Digite o valor da taxa anual: ");
            BigDecimal taxaAnual = sc.nextBigDecimal();
            ServicoDeInvestimento variavel = new InvestimentoVariavelService(valor, meses, taxaAnual);
            BigDecimal valorFinal = variavel.calcularInvestimento(valor, meses);
            System.out.println(variavel);
            System.out.println("Valor final: R$" + valorFinal);
        }
        if (escolha == 3){
            System.out.println("Escolha 1- Dollar / 2- Euro");
            int escolhaMoeda = sc.nextInt();
            sc.nextLine();

            if (escolhaMoeda == 1){
                ConversorDeMoeda dollar = new ConversorUSD(valor);
                ServicoDeInvestimento internacional = new InvestimentoCambioService(valor, meses, dollar);
                internacional.calcularInvestimento(valor, meses);
            }

        }


        sc.close();
    }

}
