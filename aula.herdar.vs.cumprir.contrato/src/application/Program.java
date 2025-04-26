package application;

import model.entities.Circulo;
import model.entities.Forma;
import model.entities.FormaAbstrata;
import model.entities.Quadrado;
import model.enums.Cor;

import java.text.Normalizer;

public class Program {
    public static void main(String[] args) {
        FormaAbstrata s1 = new Circulo(Cor.VERMELHO, 2.0);
        FormaAbstrata s2 = new Quadrado(Cor.AZUL, 3.0, 4.0);

        System.out.println("Cor do circulo: " + s1.getCor());
        System.out.println("Area do circulo: " + String.format("%.3f", s1.area()));
        System.out.println("------------------------------");
        System.out.println("Cor do retângulo: " + s2.getCor());
        System.out.println("Area do quadrado: " + String.format("%.3f", s2.area()));
    }
}
