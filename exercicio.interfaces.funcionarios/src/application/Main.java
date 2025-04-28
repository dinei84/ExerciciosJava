package application;

import model.entities.Funcionario;
import model.services.PagamentoFixo;
import model.services.PagamentoHorista;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Dados do Funcionario");
        System.out.print("Tipo de funcionario (F para Fixo / H para Horista): ");
        String escolha = sc.nextLine();

        if (escolha.equalsIgnoreCase("F")){
            System.out.print("Nome do funcionario: ");
            String nome = sc.nextLine();
            System.out.print("Qual o salario do Funcionario: ");
            Double salarioFixo = sc.nextDouble();
            sc.nextLine();

            Funcionario funcFixo = new Funcionario(nome, new PagamentoFixo(salarioFixo));

            System.out.println(funcFixo);
        }else {
            System.out.print("Nome do funcionario: ");
            String nome = sc.nextLine();
            System.out.print("Quantas horas o funcionario trabalhou: ");
            double horas = sc.nextDouble();
            sc.nextLine();
            System.out.print("Qual o valor das horas: ");
            double valorPorHora = sc.nextDouble();
            sc.nextLine();

            Funcionario funcHorista = new Funcionario(nome, new PagamentoHorista(horas, valorPorHora));

            System.out.println(funcHorista);
        }






        sc.close();
    }
}