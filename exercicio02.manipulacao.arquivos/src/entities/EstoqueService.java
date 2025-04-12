package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueService {

    public static List<Produto> lerProdutos() throws FileNotFoundException {
        String patch = "c:\\temp\\produtos\\produtos.csv";
        List<Produto> produto = new ArrayList<>();
        List<Produto> produtosParaRepor = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(patch))){
            String line = br.readLine();

            while(line != null){
                String[] itens = line.split(",");

                String nome = itens[0];
                double preco = Double.parseDouble(itens[1]);
                int quantidadeEstoque = Integer.parseInt(itens[2]);
                int quantidadeMinima = Integer.parseInt(itens[3]);

                produto.add(new Produto(nome, preco, quantidadeEstoque, quantidadeMinima));
                line = br.readLine();
            }

            for (Produto p : produto){
                if (p.precisaRepor()){
                    produtosParaRepor.add(p);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return produtosParaRepor;
    }

    public static void listaFinal(List<Produto> produtosParaRepor){
        String newPatch = "c:\\temp\\produtos";
        File pastaOrigem = new File(newPatch);

        File pasteOut = new File(pastaOrigem + "\\out");

        if (!pasteOut.exists()){
            boolean sucesso = pasteOut.mkdir();
            System.out.println("Pasta criada com sucesso? " + sucesso);
        }

        String patchEscrito = pasteOut.getPath() + "\\restock.csv";


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patchEscrito))){
            for (Produto p : produtosParaRepor){
                bw.write(p.getNome() + ", " + p.calcularReposicao());
                bw.newLine();
            }

            System.out.println("Arquivo criado com sucesso: " + patchEscrito);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
