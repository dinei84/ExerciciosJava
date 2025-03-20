package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Frete;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        Cliente ourofertil = new Cliente("OuroFertil", 7415520);
        Frete rioVerde = new Frete(); // Criando um frete único

        System.out.println("Quantos carregamentos quer colocar no frete?");
        int numero = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha

        for (int i = 0; i < numero; i++) {
            System.out.println("Vamos cadastrar o carregamento " + (i + 1));

            System.out.print("Expedidor: ");
            String expedidor = sc.nextLine();
            System.out.print("Destinatário: ");
            String destinatario = sc.nextLine();
            System.out.print("Destino final: ");
            String destinofinal = sc.nextLine();
            System.out.print("Troca de NFe: ");
            String trocaDeNfe = sc.nextLine();
            System.out.print("Pedido: ");
            String pedido = sc.nextLine();
            System.out.print("Frete Empresa: ");
            double freteEmpresa = sc.nextDouble();
            sc.nextLine();
            System.out.print("Produto: ");
            String produto = sc.nextLine();
            System.out.print("Embalagem: ");
            String embalagem = sc.nextLine();
            System.out.print("Carregado: ");
            double carregado = sc.nextDouble();
            System.out.print("Saldo: ");
            double saldo = sc.nextDouble();
            System.out.print("Frete Motorista: ");
            double freteMotorista = sc.nextDouble();
            System.out.print("Operação: ");
            int operacao = sc.nextInt();
            System.out.print("Lote: ");
            int lote = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha
            System.out.print("Localização: ");
            String localizacao = sc.nextLine();
            System.out.print("Observação: ");
            String observacao = sc.nextLine();

            // Criando a carga e adicionando ao frete
            CadastroDeCarga novaCarga = new CadastroDeCarga();
            novaCarga.setObservacao(observacao);
            novaCarga.setFreteMotorista(freteMotorista);
            novaCarga.setNfe(trocaDeNfe);

            rioVerde.addCarga(novaCarga);
        }

        System.out.println("\nResumo do Frete:");
        System.out.println("Cliente: " + ourofertil.getNome());
        System.out.println("Total de Cargas: " + rioVerde.getCargas().size());

        sc.close();
    }
}
