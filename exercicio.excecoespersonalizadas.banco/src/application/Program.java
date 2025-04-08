package application;

import entities.Conta;
import exceptions.DomainException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        List<Conta> contas = new ArrayList<>();

        while (continuar) {
            try {
                System.out.print("Cadastrar Conta (1) / Listar contas (2) / Depositar (3) / Sacar (4) / Sair (5): ");
                String escolha = sc.nextLine();
                switch (escolha) {
                    case "1":
                        System.out.println("Entre com os dados da conta");
                        System.out.print("Numero: ");
                        Integer numero = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Titular: ");
                        String titular = sc.nextLine();
                        System.out.print("Saldo: ");
                        Double saldo = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Limite de saque: ");
                        Double limite = sc.nextDouble();
                        sc.nextLine();

                        contas.add(new Conta(numero, titular, saldo, limite));
                        break;

                    case "2":
                        if (!contas.isEmpty()) {
                            System.out.println("Lista Completa:");
                            for (Conta conta : contas) {
                                System.out.println(conta);
                            }
                        } else {
                            System.out.println("Nenhuma conta cadastrada");
                        }
                        break;

                    case "3":
                        System.out.println("Contas: ");
                        for (Conta mostra : contas){
                            System.out.println(mostra.getNumber() + ", Titular: " + mostra.getTitular());
                        }

                        System.out.print("Selecione o numero da conta para o depósito: ");
                        String selecao = sc.nextLine().trim();

                        Conta contaSelecionada = null;
                        for (Conta cta : contas) {
                            if (cta.getTitular() != null && String.valueOf(cta.getNumber()).equals(selecao)) {
                                contaSelecionada = cta;
                                break;
                            }
                        }

                        if (contaSelecionada != null) {
                            try {
                                System.out.println("Conta selecionada: " + contaSelecionada.getTitular());
                                System.out.print("Valor do depósito: ");
                                Double deposito = sc.nextDouble();
                                sc.nextLine();

                                contaSelecionada.depositar(deposito);

                                System.out.println("Saldo Atualizado da conta: " + contaSelecionada.getTitular() + " é: R$" + contaSelecionada.getSaldo());
                            } catch (InputMismatchException e) {
                                System.out.println("Valor inválido para depósito.");
                                sc.nextLine();
                            }
                        } else {
                            System.out.println("Conta não encontrada");
                        }
                        break;

                    case "4":
                        imprimirContas(contas);

                        System.out.print("Selecione o número da conta para saque: ");
                        String select = sc.nextLine().trim();

                        Conta ctaSelecionada = buscarConta(contas, select);


                        if (ctaSelecionada != null) {
                            try {
                                System.out.println("Conta de: " + ctaSelecionada.getTitular());
                                System.out.print("Qual o valor do saque: ");
                                Double saque = sc.nextDouble();
                                sc.nextLine();

                                try {
                                    ctaSelecionada.sacar(saque);
                                    System.out.printf("Você sacou %.2f%n e seu novo saldo é: R$%.2f%n", saque, ctaSelecionada.getSaldo());
                                } catch (DomainException.SaldoInsuficiente e) {
                                    System.out.println("Erro de saque: " + e.getMessage());
                                } catch (DomainException.LimiteSaqueExcedido e) {
                                    System.out.println("Está tentando sacar: R$" + saque + ". Erro de saque: " + e.getMessage());
                                } catch (DomainException.ValorInvalido e) {
                                    System.out.println("Erro de saque: " + e.getMessage());
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Valor inválido para saque.");
                                sc.nextLine();
                            }
                        } else {
                            System.out.println("Conta não encontrada");
                        }
                        break;

                    case "5":
                        continuar = false;
                        System.out.println("Saindo...");
                        break;

                    default:
                        throw new IllegalStateException("Opção inválida: " + escolha);
                }
            } catch (IllegalStateException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                sc.nextLine();
            }
        }

        sc.close();
    }

    private static void imprimirContas(List<Conta> contas) {
        System.out.println("Contas:");
        for (Conta c : contas) {
            System.out.println("Número: " + c.getNumber() + ", Titular: " + c.getTitular());
        }
    }

    private static Conta buscarConta(List<Conta> contas, String numero) {
        for (Conta c : contas) {
            if (String.valueOf(c.getNumber()).equals(numero)) {
                return c;
            }
        }
        return null;
    }


}
