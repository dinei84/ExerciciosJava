package application;

import entities.Conta;
import exceptions.DomainException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados da conta");
        System.out.print("Numero: ");
        Integer numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Titular: ");
        String titular = sc.nextLine();
        System.out.print("Saldo: ");
        Double saldo = sc.nextDouble();
        System.out.print("Limite de saque: ");
        Double limite = sc.nextDouble();

        Conta c1 = new Conta(numero, titular, saldo, limite);

        System.out.print("Qual o valor do saque: ");
        Double saque = sc.nextDouble();

        System.out.println(c1);

        try {
            c1.sacar(saque);
            System.out.printf("Voce sacou %.2f%n e seu novo saldo é: R$%.2f%n", saque, c1.getSaldo());
        } catch (DomainException.SaldoInsuficienteException e) {
            System.out.println("Erro de saque: " + e.getMessage());
        } catch (DomainException.LimiteSaqueExcedidoException e) {
            System.out.println("Esta tentando sacar: R$" + saque + " erro de saque: " + e.getMessage());
        } catch (DomainException.ValorInvalidoException e) {
            System.out.println("Erro de saque: " + e.getMessage());
        }




        sc.close();
    }
}
