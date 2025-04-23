package application;

import model.entities.Encomenda;
import model.entities.SimuladorDeFrete;
import model.services.ServicoDeFrete;
import model.services.TransportadoraEconomica;
import model.services.TransportadoraRapida;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Locale.setDefault(Locale.US);


        System.out.println("+--Transportadora Jabuti--+");
        System.out.println("+-------------------------+");
        System.out.println("     Dados do Frete");
        System.out.println("----------------------------");

        System.out.print("Nome do usuario: ");
        String nome = sc.nextLine();
        System.out.print("Qual a distancia a percorrer (Km): ");
        double distancia = sc.nextDouble();
        System.out.print("Peso do objeto: ");
        double peso = sc.nextDouble();
        sc.nextLine();
        System.out.print("Quer usar o frete economico ou rapido? (E/R): ");
        String escolha = sc.nextLine();

        Encomenda encomenda = new Encomenda(nome, distancia, peso);
        SimuladorDeFrete simulador;

        if (escolha.equalsIgnoreCase("E")){
            simulador = new SimuladorDeFrete(new TransportadoraEconomica(), encomenda);
        }else {
            simulador = new SimuladorDeFrete(new TransportadoraRapida(), encomenda);
        }

        simulador.simularFrete();



        sc.close();
    }
}
