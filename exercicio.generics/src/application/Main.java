package application;

import entities.Alimento;
import entities.Eletronico;
import entities.Livro;
import services.Catalogo;
import services.Produto;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Catalogo<Produto> catalogo = new Catalogo<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Quantos produtos deseja adicionar? ");
        int total = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < total; i++) {
            System.out.print("Tipo (1-Eletrônico, 2-Livro, 3-Alimento): ");
            int tipo = Integer.parseInt(sc.nextLine());

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Preço: ");
            BigDecimal preco = new BigDecimal(sc.nextLine());

            switch (tipo) {
                case 1 -> {
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    catalogo.adicionarProduto(new Eletronico(nome, preco, marca));
                }
                case 2 -> {
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    catalogo.adicionarProduto(new Livro(nome, preco, autor));
                }
                case 3 -> {
                    System.out.print("Validade (dd/MM/yyyy): ");
                    try {
                        Date validade = sdf.parse(sc.nextLine());
                        catalogo.adicionarProduto(new Alimento(nome, preco, validade));
                    } catch (ParseException e) {
                        System.out.println("Data inválida. Produto não adicionado.");
                    }
                }
                default -> System.out.println("Tipo inválido.");
            }
        }

        System.out.println("\n--- Produtos Adicionados ---");
        for (Produto p : catalogo.listarProdutos()) {
            System.out.println(p.getNome() + " - R$" + p.getPreco());
        }

        Produto maisCaro = catalogo.obterMaisCaro();
        Produto maisBarato = catalogo.obterMaisBarato();

        System.out.println("\nMais caro: " + maisCaro.getNome() + " - R$" + maisCaro.getPreco());
        System.out.println("Mais barato: " + maisBarato.getNome() + " - R$" + maisBarato.getPreco());

        sc.close();
    }
}
