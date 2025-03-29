package application;

import entities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Bem-vindo ao Jogo de Luta Dragon Ball Z (Terminal) ---");

        System.out.print("Digite o nome do Jogador 1: ");
        String jogador1 = scanner.nextLine();

        System.out.print("Digite o nome do Jogador 2: ");
        String jogador2 = scanner.nextLine();

        Luta luta = new Luta(jogador1, jogador2);

        // Criando os personagens disponíveis
        List<Guerreiro> personagens = new ArrayList<>();
        personagens.add(new Saiyajin("Goku", 100, 30, 15, "Planeta Vegeta"));
        personagens.add(new Saiyajin("Vegeta", 90, 28, 18, "Planeta Vegeta"));
        personagens.add(new Humano("Kuririn", 70, 15, 10, "Kienzan"));
        personagens.add(new Namekiano("Piccolo", 85, 25, 12, true));
        personagens.add(new Guerreiro("Yamcha", 60, 12, 8));

        luta.escolherPersonagens(personagens);
        luta.iniciarLuta();

        scanner.close();
    }
}
