package application;

import entities.Funcionario;
import entities.FuncionarioTerceirizado;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Quantos funcionarios quer calcular: ");
        int numero = sc.nextInt();

        for (int i = 0; i < numero; i++) {
            System.out.print("Dados do funcionario " + (i + 1) + "°");
            System.out.println("Digite y se o funcionario for Terceirizado, ou n se for Funcionario comum: ");
            String tipo = sc.next().charAt(0);
            if (tipo.equals('y')){
                System.out.print("Nome: ");
                String nome = sc.next();
                System.out.print("Horas: ");
                int horas = sc.nextInt();
            }


        }






        sc.close();
    }
}