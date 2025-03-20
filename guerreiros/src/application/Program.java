package application;

import entities.Guerreiro;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Guerreiro goku = new Guerreiro("Saiajin", 10000.00, "Kamehameha", "Goku");

        System.out.println(goku);



        sc.close();
    }
}
