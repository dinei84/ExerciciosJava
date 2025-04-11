package entities;

import java.io.*;
import java.util.List;

public class EstoqueService {


    public static void lerProdutos() throws FileNotFoundException {
        String patch = "c:\\temp\\produtos\\produtos.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(patch))){
            String line = br.readLine();

            while(line != null){
                String[] itens = line.split(",");

                String nome = itens[0];
                double preco = Double.parseDouble(itens[1]);
                int quantidadeEstoque = Integer.parseInt(itens[2]);
                int quantidadeMinima = Integer.parseInt(itens[3]);

                Produto produto = new Produto(nome, preco, quantidadeEstoque, quantidadeMinima);

                if(produto.quantidadeEstoque > produto.quantidadeMinima){
                    produto.calcularReposicao(quantidadeEstoque, quantidadeMinima);
                }

                line = br.readLine();
            }

            System.out.println(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void listaFinal(List<String> produto){
        String newPatch = "c:\\temp\\produtos\\produtos.csv";
        File pastaOrigem = new File(newPatch);

        File pasteOut = new File(pastaOrigem + "\\out");

        boolean sucesso = pasteOut.mkdir();
        System.out.println("Pasta criada com sucesso!" + sucesso);

        String patchEscrito = pasteOut.getPath() + "\\restock.csv";


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patchEscrito))){
            for (String line : produto){
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Arquivo criado com sucesso" + patchEscrito);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
