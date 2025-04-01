package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();

        System.out.print("Quantos tipos de pessoa vai adicionar: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Vamos aos dados da " + (i + 1) + "° pessoa");
            System.out.print("É PJ ou PF? (j/f)");
            char tipo = sc.next().toLowerCase().charAt(0);

            System.out.print("Nome da pessoa: ");
            String nome = sc.next();
            System.out.print("Renda anual: ");
            Double renda = sc.nextDouble();;

            if (tipo == 'j'){
                System.out.print("Numero de Funcionarios: ");
                Integer funcionarios = sc.nextInt();
//                sc.nextLine();

                pessoas.add(new PessoaJuridica(nome, renda, funcionarios));
            }else{
                System.out.print("Valor de gastos com saude: ");
                Double saude = sc.nextDouble();

                pessoas.add(new PessoaFisica(nome, renda, saude));
            }

        }


        System.out.println();
        System.out.println("Pagamento das taxas");
        for (Pessoa pessoa : pessoas){
            System.out.printf("Nome: %s, Taxa: %.2f%n", pessoa.getNome(), pessoa.calcularImposto());
        }

        sc.close();
    }
}
