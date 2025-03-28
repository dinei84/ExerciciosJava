package application;

import entities.Funcionario;
import entities.FuncionarioTerceirizado;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Funcionario> funcionarios = new ArrayList<>();

        System.out.print("Quantos funcionarios quer calcular: ");
        int numero = sc.nextInt();

        for (int i = 0; i < numero; i++) {
            System.out.println("Dados do Funcionario");
            System.out.print("Funcionario #" + (i + 1)  + "°, é Terceirizado(s/n)");
            char tipo = sc.next().toLowerCase().charAt(0);

            System.out.print("Nome do funcionario: ");
            sc.nextLine();
            String nome = sc.nextLine();

            System.out.print("Horas trabalhadas pelo funcionario: ");
            Integer horas = sc.nextInt();

            System.out.print("Qual o valor da hr trabalhada: ");
            Double valor = sc.nextDouble();

            if (tipo == 's'){
                System.out.print("Valor da despesa adicional: ");
                Double despesas = sc.nextDouble();
                funcionarios.add(new FuncionarioTerceirizado(nome, valor, horas, despesas));
            }else{
                funcionarios.add(new Funcionario(nome, valor, horas));
            }
        }

        System.out.println();
        System.out.println("Pagamentos: ");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - R$" + funcionario.pagamento());
        }






        sc.close();
    }
}