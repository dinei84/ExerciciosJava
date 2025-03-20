package application;

import entities.Guerreiro;
import entities.Humanos;
import entities.Namecuseijin;
import entities.Saiajin;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Saiajin goku = new Saiajin("Sayajin", 1000, "Kamehameha", 2, "Planeta Vegita", "Goku");
        goku.trasnformacao(3);

        Namecuseijin picolo = new Namecuseijin("Namecusaijim", 5000, "Aquencosapo", 1200, "Regeneração", "Picollo");
        picolo.setFundir(3500);

        Humanos kuririn = new Humanos("Humanos", 3500, "Kiensan", "Kuririn", "Kame");

        System.out.println(goku);
        System.out.println(picolo);
        System.out.println(kuririn);

        sc.close();
    }
}
