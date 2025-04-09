package application;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com o caminho da pasta (patch)");
        String strPatch = sc.nextLine();

        File patch = new File(strPatch);


        //Procurando pastas
//        File[] pastas = patch.listFiles(File::isDirectory);
//        System.out.println("Pastas");
//        for (File pasta : pastas){
//            System.out.println(pasta);
//        }

        // procurando arquivos
//        File[] arquivos = patch.listFiles(File::isFile);
//        System.out.println("Arquivos:");
//        for (File arquivo : arquivos){
//            System.out.println(arquivo);
//        }
        // criando uma subpasta
        boolean sucesso = new File(strPatch + "\\subdir").mkdir();
        System.out.println("Diretorio criado com sucesso " + sucesso);

        sc.close();
    }
}
