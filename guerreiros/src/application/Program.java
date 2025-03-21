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
        Saiajin gohan = new Saiajin("Saiajin", 2500, "Mazenko", 2, "Terra", "Gohan");
        Saiajin tranksdofuturo = new Saiajin("Saiajin", 2000, "Ataque de Espada Brilhante", 1, "Futuro", "Trunks");

        Namecuseijin picolo = new Namecuseijin("Namecusaijim", 5000, "Aquencosapo", 1200, "Regeneração", "Picollo");
        Namecuseijin dende = new Namecuseijin("Namecuseijin", 100, "Não possui", 200, "Cura", "Dende");

        Humanos kuririn = new Humanos("Humanos", 3500, "Kiensan", "Kuririn", "Kame");
        Humanos iancha = new Humanos("Humanos", 4200, "Golpe do Lobo", "Iancha", "Kame");
        Humanos tenshinhan = new Humanos("Humanos", 5000, "Kikohan", "Tenshinhan", "Tsuru-Sen'nin");

        System.out.println(goku);
        System.out.println(vegita);
        System.out.println(gohan);
        System.out.println(tranksdofuturo);


        System.out.println(picolo);
        System.out.println(dende);


        System.out.println(kuririn);
        System.out.println(iancha);
        System.out.println(tenshinhan);

        sc.close();
    }
}
