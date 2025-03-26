package application;

import entities.Conta;
import entities.ContaNegocios;
import entities.ContaPoupanca;

public class Program {
    public static void main(String[] args) {

        Conta conta1 = new Conta(1005,"Dinei", 5000.0);
        System.out.println("Saldo da Conta Corrente: " + conta1.getSaldo());
        System.out.println("-----------------");
        conta1.retirada(500);
        System.out.println("Saque da Conta Corrente: " + conta1.getSaldo());

        System.out.println("==================================================");

        Conta contap = new ContaPoupanca(1010, "Fernanda", 2500.0, 12.0);
        System.out.println("Saque da Conta Poupança: " + contap.getSaldo());
        System.out.println("------------------");
        contap.retirada(250.0);
        System.out.println("Saque da Conta Poupança: " + contap.getSaldo());

        System.out.println("==================================================");

        Conta contabusi = new ContaNegocios(1010, "Felipe", 3500.0, 1000.0);
        System.out.println("Saldo da Conta Business: " + contabusi.getSaldo());
        System.out.println("-------------------");
        contabusi.retirada(1000.0);
        System.out.println("Saque da conta Business: " + contabusi.getSaldo());

    }
}
