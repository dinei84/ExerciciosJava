package application;

import entities.Alimento;
import entities.Eletronico;
import entities.Livro;
import services.Catalogo;
import services.Produto;
import services.ProdutoClass;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static <T extends Produto> void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Catalogo<T> produtos = new Catalogo<T>();

        System.out.println("Vamos adicionar produtos");
        System.out.print("Quantos produtos quer adicionar: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int quantidadeEscolhas = 0;

        System.out.print("Qual o tipo de produto: 1.Eletronico / 2.Livro / 3.Alimento");
        int escolha = sc.nextInt();
        sc.nextLine();

        while (quantidadeEscolhas <= escolha) {

            if (escolha == 1) {
                System.out.print("Qual o nome do Produto: ");
                String nome = sc.nextLine();
                System.out.print("Qual o preço do Produto: ");
                BigDecimal preco = sc.nextBigDecimal();
                sc.nextLine();
                System.out.print("Qual a marca do Produto: ");
                String marca = sc.nextLine();
                produtos.addProduto((T) new Eletronico(nome, preco, marca));
            }

            if (escolha == 2) {
                System.out.print("Qual o nome do Produto: ");
                String nomeLivro = sc.nextLine();
                System.out.print("Qual o preço do Produto: ");
                BigDecimal precoLivro = sc.nextBigDecimal();
                sc.nextLine();
                System.out.print("Qual o Autor do Livro: ");
                String autor = sc.nextLine();
                produtos.addProduto((T) new Livro(nomeLivro, precoLivro, autor));
            }

            if (escolha == 3) {
                System.out.print("Qual o nome do Produto: ");
                String nomeAlimento = sc.nextLine();
                System.out.print("Qual o preço do Produto: ");
                BigDecimal preconomeAlimento = sc.nextBigDecimal();
                sc.nextLine();
                System.out.print("Qual a Data de Validade: ");
                String dataStr = sc.nextLine();
                Date validade = null;
                try {
                    validade = sdf.parse(dataStr);
                } catch (ParseException e) {
                    System.out.println("Formato invalido");
                }
                produtos.addProduto((T) new Alimento(nomeAlimento, preconomeAlimento, validade));
            }

        }
        sc.close();
    }
}