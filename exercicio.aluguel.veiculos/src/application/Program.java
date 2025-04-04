package application;

import entities.Carro;
import entities.Moto;
import entities.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Veiculo> veiculos = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.print("O que deseja fazer? Cadastrar(1) / Listar(2) / Simular Aluguel(3) / Sair(4)");
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Deseja cadastrar: Carro (1) / Moto (2)");
                    int escolhaVeiculo = sc.nextInt();
                    sc.nextLine();

                    switch (escolhaVeiculo) {
                        case 1:
                            System.out.print("Modelo:");
                            String modelo = sc.nextLine();

                            System.out.print("Marca: ");
                            String marca = sc.nextLine();

                            System.out.print("Ano Fabricação: ");
                            int anoFabricacao = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Preço base do aluguel: ");
                            Double precoBase = sc.nextDouble();
                            sc.nextLine(); // Adicionei para evitar problemas com o nextLine

                            System.out.print("Quantidade de portas: ");
                            int quantidadePortas = sc.nextInt();
                            sc.nextLine();

                            veiculos.add(new Carro(modelo, marca, anoFabricacao, precoBase, quantidadePortas));
                            break;
                        case 2:
                            System.out.print("Modelo:");
                            String modeloMoto = sc.nextLine();

                            System.out.print("Marca: ");
                            String marcaMoto = sc.nextLine();

                            System.out.print("Ano Fabricação: ");
                            int anoFabricacaoMoto = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Preço base do aluguel: ");
                            Double precoBaseMoto = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Cilindrada: ");
                            int cilindrada = sc.nextInt();
                            sc.nextLine();

                            veiculos.add(new Moto(modeloMoto, marcaMoto, anoFabricacaoMoto, precoBaseMoto, cilindrada));
                    }
                    break;
                case 2:
                    if (!veiculos.isEmpty()) {
                        for (Veiculo veiculo : veiculos) {
                            System.out.println(veiculo);
                        }
                    } else {
                        System.out.println("Nenhum veículo cadastrado!");
                    }
                    break;
                case 3:
                    System.out.println("Quer simular o aluguel de: Carro (1) / Moto (2)");
                    int escolhaSimulacao = sc.nextInt();
                    sc.nextLine();

                    switch (escolhaSimulacao) {
                        case 1:
                            System.out.print("Modelo do veículo: ");
                            String modeloSimulacao = sc.nextLine();

                            System.out.print("Marca do veículo: ");
                            String marcaSimulacao = sc.nextLine();

                            System.out.print("Ano de fabricação: ");
                            int anoFabricacaoSimulacao = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Preço Base: ");
                            Double precoBaseSimulacao = sc.nextDouble();
                            sc.nextLine(); 

                            System.out.print("Quantos dias Alugado: ");
                            int diasAlugado = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Quantidade de portas: ");
                            int quantidadePortasSimulacao = sc.nextInt();
                            sc.nextLine();

                            // Aqui você está adicionando um novo carro, mas não está simulando o aluguel
                            // Você pode criar um método para simular o aluguel em vez de adicionar um novo veículo
                            veiculos.add(new Carro(modeloSimulacao, marcaSimulacao, anoFabricacaoSimulacao, precoBaseSimulacao, quantidadePortasSimulacao));
                            break;
                        case 2:
                            System.out.print("Modelo:");
                            String modeloMotoSimulacao = sc.nextLine();

                            System.out.print("Marca: ");
                            String marcaMotoSimulacao = sc.nextLine();

                            System.out.print("Ano Fabricação: ");
                            Integer anoFabricacaoMotoSimulacao = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Preço base do aluguel: ");
                            Double precoBaseMotoSimulacao = sc.nextDouble();
                            sc.nextLine(); // Adicionei para evitar problemas com o nextLine

                            System.out.print("Dias alugado: ");
                            Integer diasAlugadoMoto = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Cilindrada: ");
                            Integer cilindradaSimulacao = sc.nextInt();
                            sc.nextLine();

                            // Aqui você está adicionando um novo moto, mas não está simulando o aluguel
                            // Você pode criar um método para simular o aluguel em vez de adicionar um novo veículo
                            veiculos.add(new Moto(modeloMotoSimulacao, marcaMotoSimulacao, anoFabricacaoMotoSimulacao, precoBaseMotoSimulacao, cilindradaSimulacao));
                    }
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção não reconhecida!");
            }
        }

        sc.close();
    }
}
