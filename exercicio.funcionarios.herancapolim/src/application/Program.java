package application;

import entities.Funcionario;
import entities.FuncionarioTerceirizado;

public class Program {
    public static void main(String[] args) {
        FuncionarioTerceirizado dinei = new FuncionarioTerceirizado();
        dinei.setNome("Dinei");
        dinei.setHoras(100);
        dinei.setValorPorHora(15.0);
        dinei.setDespesasAdicionais(200.0);

        System.out.println(dinei);

//        Funcionario fernanda = new Funcionario();
//        fernanda.setNome("Fernanda");
//        fernanda.setHoras(50);
//        fernanda.setValorPorHora(20.0);
//
//        System.out.println(fernanda);






    }
}