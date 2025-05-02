package application;

import services.*;

import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Tipo de frete (1 = Nacional, 2 = Internacional): ");
        int tipo = sc.nextInt();

        System.out.print("Peso do pacote (kg): ");
        double peso = sc.nextDouble();

        System.out.print("Valor do seguro (R$): ");
        double seguro = sc.nextDouble();

        ServicoDeFrete frete;

        if (tipo == 1) {
            frete = new FreteNascional();
        } else if (tipo == 2) {
            frete = new FreteInternacional();
        } else {
            System.out.println("Tipo de frete inválido.");
            sc.close();
            return;
        }

        double total = frete.calcular(peso, seguro);
        System.out.printf("Valor total do frete: R$ %.2f%n", total);

        sc.close();
    }
}
