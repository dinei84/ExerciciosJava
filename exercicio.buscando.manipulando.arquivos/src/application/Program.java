package application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        String patch = "c:\\temp\\arquivo.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(patch))){
            String line = br.readLine();

            while (line != null){

                String[] itens = line.split(",");

                String nome = itens[0];
                double preco = Double.parseDouble(itens[1]);
                int quantidade = Integer.parseInt(itens[2]);

                Double total = preco * quantidade;
                System.out.println(nome + ", " + total);

                List<String> dados = new ArrayList<>();

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        String caminho = "C:\\temp\\";
        boolean sucesso = new File(caminho + "\\somados").mkdir();
        System.out.println("Pasta criada com sucesso!" + sucesso);

        String patchEscrito = "c:\\temp\\somados\\somados.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patchEscrito))){
            for (String line : line){
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
