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
import java.util.List;
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

        for (int i = 0; i < quantidade; i ++ ) {
            System.out.print("Qual o tipo de produto: 1.Eletronico / 2.Livro / 3.Alimento: ");
            int escolha = sc.nextInt();
            sc.nextLine();

            if (escolha == 1) {
                System.out.print("Qual o nome do Produto: ");
                String nome = sc.nextLine();
                System.out.print("Qual o preço do Produto: ");
                BigDecimal preco = sc.nextBigDecimal();
                sc.nextLine();
                System.out.print("Qual a marca do Produto: ");
                String marca = sc.nextLine();
                produtos.addProduto((T) new Eletronico(nome, preco, marca));
//                System.out.println("\nProduto adicionado com sucesso!");
//                System.out.println("Nome: " + nome + ", Preço: " + preco + ", Marca: " + marca);
//                System.out.println("------------------------");
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
//                System.out.println("\nProduto adicionado com sucesso!");
//                System.out.println("Nome: " + nomeLivro + ", Preço: " + precoLivro + ", Autor: " + autor);
//                System.out.println("------------------------");
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
//                System.out.println("\nProduto adicionado com sucesso!");
//                System.out.println("Nome: " + nomeAlimento + ", Preço: " + preconomeAlimento + ", Data de Validade: " + sdf.format(validade));
//                System.out.println("------------------------");
            }
        }

        // Listar todos os produtos adicionados
        System.out.println("\nProdutos adicionados:");
        List<T> todosProdutos = produtos.listarProdutos();
        
        for (T produto : todosProdutos) {
            System.out.println("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco());
            if (produto instanceof Eletronico) {
                System.out.println("Marca: " + ((Eletronico) produto).getMarca());                
            } else if (produto instanceof Livro) {
                System.out.println("Autor: " + ((Livro) produto).getAutor());                
            } else if (produto instanceof Alimento) {
                System.out.println("Data de Validade: " + sdf.format(((Alimento) produto).getValidade()));                
            }
            System.out.println("------------------------");
        }

        System.out.println("Produto mais caro:");
        System.out.println(produtos.obterMaisCaro());
        System.out.println("\nProduto mais barato:");
        System.out.println(produtos.obterMaisBarato());



        sc.close();
    }
}