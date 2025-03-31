package application;

import entities.Circulo;
import entities.Forma;
import entities.Retangulo;
import entities.enums.Cor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Forma> formas = new ArrayList<>();

        System.out.print("Quantos elementos quer calcular a area: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Retangulo ou circulo (r/c): ");
            char tipo = sc.next().toLowerCase().charAt(0);
            System.out.print("Cor da Circulo (PRETO, AZUL, VERMELHO) ");
            Cor cor = Cor.valueOf(sc.next());

            if (tipo == 'c'){
                System.out.print("Qual o raio do Círculo: ");
                Double raio  = sc.nextDouble();

                formas.add(new Circulo(cor, raio));
            }
            if (tipo == 'r'){
                System.out.print("Largura do Retangulo: ");
                Double largura = sc.nextDouble();
                System.out.print("Altura do Retangulo: ");
                Double altura = sc.nextDouble();

                formas.add(new Retangulo(cor, altura, largura));
            }
        }

        System.out.println();
        System.out.println("Areas das formas");
        for (Forma forma : formas){
            System.out.println(String.format("%.2f",forma.area()));
        }



        sc.close();
    }
}
