package application;

import entities.Conta;
import entities.ContaNegocios;
import entities.ContaPoupanca;

public class Program {
    public static void main(String[] args) {

        Conta acc = new Conta(115,"Dinei", 1500.0 );
        ContaNegocios bacc = new ContaNegocios(1002, "Fernanda", 0.0, 500.0);

        //UPCASTING

        Conta acc1 = bacc;
        Conta acc2 = new ContaNegocios(1003, "Vini", 1500.0, 2000.0);
        Conta acc3 = new ContaPoupanca(1004, "Felipe", 2500.0, 0.5);

        //DOWCASTING

        ContaNegocios acc4 = (ContaNegocios) acc2;
        acc4.emprestimo(100);

        //ContaNegocios acc5 = (ContaNegocios) acc3;
        if (acc3 instanceof ContaNegocios) {
            ContaNegocios acc5 = (ContaNegocios) acc3;
            acc5.emprestimo(100.0);
            System.out.println("Emprestado");
        }
        if (acc3 instanceof ContaPoupanca){
            ContaPoupanca acc5 = (ContaPoupanca) acc3;
            acc5.atualizaSaldo();
            System.out.println("Atualizado");
        }

    }
}
