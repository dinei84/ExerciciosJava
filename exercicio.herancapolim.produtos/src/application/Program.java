package application;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<>();

        System.out.print("Quantos produtos vão ser cadastrados: ");
        int numero = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numero; i++) {
            System.out.print("Tipo do produto: usado, importado, comum (u/i/c)");
            char tipo = sc.next().toLowerCase().charAt(0);

            sc.nextLine();
            System.out.print("Nome do produto: ");
            String nome = sc.nextLine();

            System.out.print("Preço do Produto: ");
            Double preco = sc.nextDouble();

            if (tipo == 'c'){
                produtos.add(new Produto(nome, preco));
            }
            if (tipo == 'u'){
                sc.nextLine();
                System.out.print("Digite a data de fabricação: ");
                String data = sc.nextLine();

                produtos.add(new ProdutoUsado(nome, preco, data));
            }
            if (tipo == 'i'){

                System.out.print("Taxa de Importação: ");
                Double taxa = sc.nextDouble();

                produtos.add(new ProdutoImportado(nome, preco, taxa));
            }

        }

        System.out.println();
        System.out.println("Etiquetas de Preço: ");
        for(Produto produto : produtos){
            System.out.println(produto);
        }



        sc.close();
    }
}
