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
        Saiajin vegita = new Saiajin("Sayajin", 1000, "Alvorecer do Dia", 2, "Planeta Vegita", "Vegita");

        Namecuseijin picolo = new Namecuseijin("Namecusaijim", 5000, "Aquencosapo", 1200, "Regeneração", "Picollo");
        picolo.setFundir(3500);

        Humanos kuririn = new Humanos("Humanos", 3500, "Kiensan", "Kuririn", "Kame");
        Humanos iancha = new Humanos("Humanos", 4200, "Golpe do Lobo", "Iancha", "Kame");

        System.out.println(goku);
        System.out.println(picolo);
        System.out.println(kuririn);
        System.out.println(iancha);

        sc.close();
    }
}
