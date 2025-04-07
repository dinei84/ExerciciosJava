package application;

import entities.Conta;

public class Program {
    public static void main(String[] args) {
        Conta c1 = new Conta(8522, "Dinei", 500.0, 300.0);

        c1.sacar(100.0);

        System.out.println(c1);


    }
}
