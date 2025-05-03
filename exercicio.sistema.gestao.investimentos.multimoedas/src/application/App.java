package application;

import currency.ConversorDeMoeda;
import currency.ConversorEUR;
import currency.ConversorUSD;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        BigDecimal valor = new BigDecimal("1500.00");

        ConversorDeMoeda dollar = new ConversorEUR(valor);

        System.out.println(dollar);



        sc.close();
    }
}
