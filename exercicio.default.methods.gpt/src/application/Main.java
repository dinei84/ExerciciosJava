package application;

import services.ServicoDeImposto;
import services.ServicoImpostoBrasil;
import services.ServicoImpostoEuropa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Selecione o país (1 = Brasil, 2 = Europa): ");
        int opcao = sc.nextInt();

        System.out.print("Valor do investimento: ");
        double valor = sc.nextDouble();

        System.out.print("Quantidade de meses: ");
        int meses = sc.nextInt();

        ServicoDeImposto servico;

        if (opcao == 1) {
            servico = new ServicoImpostoBrasil();
        } else if (opcao == 2) {
            servico = new ServicoImpostoEuropa();
        } else {
            System.out.println("Opção inválida!");
            sc.close();
            return;
        }

        double resultado = servico.calcular(valor, meses);
        System.out.printf("Valor após %d meses: R$ %.2f%n", meses, resultado);

        sc.close();
    }
}
