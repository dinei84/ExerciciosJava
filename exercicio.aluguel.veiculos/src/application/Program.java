package application;

import entities.Carro;
import entities.Moto;
import entities.Veiculo;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Veiculo> veiculos = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print("O que deseja fazer? Cadastrar(1) / Listar(2) / Simular Aluguel(3) / Sair(4) ");
                int escolha = sc.nextInt();
                sc.nextLine();

                switch (escolha) {
                    case 1:
                        System.out.print("Deseja cadastrar: Carro (1) / Moto (2) ");
                        int escolhaVeiculo = sc.nextInt();
                        sc.nextLine();

                        switch (escolhaVeiculo) {
                            case 1:
                                System.out.print("Modelo: ");
                                String modelo = sc.nextLine();

                                System.out.print("Marca: ");
                                String marca = sc.nextLine();

                                System.out.print("Ano Fabricação: ");
                                Integer anoFabricacao = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Preço base do aluguel: ");
                                Double precoBase = sc.nextDouble();
                                sc.nextLine();

                                System.out.print("Quantidade de portas: ");
                                Integer quantidadePortas = sc.nextInt();
                                sc.nextLine();

                                veiculos.add(new Carro(modelo, marca, anoFabricacao, precoBase, quantidadePortas));
                                break;
                            case 2:
                                System.out.print("Modelo: ");
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
                        try {
                            if (!veiculos.isEmpty()) {
                                System.out.println("Listagem Completa: ");
                                for (Veiculo veiculo : veiculos) {
                                    System.out.println(veiculo);
                                }
                            } else {
                                System.out.println("Nenhum veículo cadastrado!");
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Não achado!" + new Exception(e));
                        }

                        break;
                    case 3:
                        System.out.print("Qual modelo do veículo quer simular: ");
                        String modeloBusca = sc.nextLine().trim(); // Remove espaços em branco

                        Veiculo encontrado = null;
                        for (Veiculo v : veiculos) {
                            if (v.getModelo() != null && v.getModelo().equalsIgnoreCase(modeloBusca)) {
                                encontrado = v;
                                break;
                            }
                        }

                        if (encontrado != null) {
                            try {
                                System.out.print("Por quantos dias quer alugar: ");
                                int diasAlugado = sc.nextInt();
                                sc.nextLine(); // Consume newline left-over

                                Double valor = encontrado.calcularAluguel(diasAlugado);
                                System.out.printf("O valor do aluguel do veículo: %s, por %d dias, é: %.2f %n", encontrado.getModelo(), diasAlugado, valor);
                            } catch (NullPointerException e) {
                                System.out.println("Erro ao calcular aluguel. Verifique os dados do veículo.");
                            } catch (Exception e) {
                                System.out.println("Erro inesperado: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Não encontramos esse veículo.");
                        }

                        break;

                    case 4:
                        continuar = false;
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção não reconhecida!");
                }
            }catch (InputMismatchException e){
                System.out.println("Opção invalida!!");
                sc.nextLine();
            }
        }

        sc.close();
    }
}
