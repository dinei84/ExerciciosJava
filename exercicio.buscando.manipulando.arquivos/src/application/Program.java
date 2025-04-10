package application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        String patch = "c:\\temp\\arquivo.csv";

        List<String> linhasTratadas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(patch))) {
            String line = br.readLine();

            while (line != null) {
                String[] itens = line.split(",");

                String nome = itens[0];
                double preco = Double.parseDouble(itens[1]);
                int quantidade = Integer.parseInt(itens[2]);

                double total = preco * quantidade;

                linhasTratadas.add(nome + ", " + String.format("%.2f", total));

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Parte nova: gerar pasta "out" e salvar "summary.csv" dentro dela
        File arquivoOriginal = new File(patch);
        String pastaOrigem = arquivoOriginal.getParent();
        File pastaOut = new File(pastaOrigem + "\\out");

        boolean sucesso = pastaOut.mkdir();
        System.out.println("Pasta criada com sucesso? " + sucesso);

        String patchEscrito = pastaOut.getPath() + "\\summary.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patchEscrito))) {
            for (String line : linhasTratadas) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Arquivo criado com sucesso em: " + patchEscrito);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
