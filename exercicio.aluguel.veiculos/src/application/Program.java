package application;

import entities.Carro;
import entities.Veiculo;

public class Program {
    public static void main(String[] args) {

        Veiculo v1 = new Carro("Corsa", "Chevrolet", 2024, 240.0, 4, 4);

        v1.calcularAluguel(5);

        System.out.println(v1);



    }
}
