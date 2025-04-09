package application;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com o caminho do arquivo: ");
        String strPatch = sc.nextLine();

        File patch = new File(strPatch);

        System.out.println("Buscando somente o nome do arquivo com getName(): " + patch.getName());
        System.out.println("Buscando somente o nome do caminho, sem o arquivo com getParent(): " + patch.getParent());
        System.out.println("Buscando todo o nome do arquivo com getPatch(): " + patch.getPath());
        System.out.println("Parecido com o getPatch " + patch.getAbsolutePath());
        System.out.println("Buscando" + patch.getUsableSpace());







        sc.close();
    }
}
