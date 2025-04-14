package application;

import model.entities.AluguelVeiculo;
import model.entities.Veiculo;
import model.services.BrasilTaxas;
import model.services.ServicoDeAluguel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre ocm os dados do aluguel");

        System.out.print("Modelo do carro: ");
        String carroModelo = sc.nextLine();
        System.out.print("Data e hora da Retirada: ");
        LocalDateTime dataRetirada = LocalDateTime.parse(sc.nextLine(), sdf);
        System.out.print("Data da entrega do veiculo: ");
        LocalDateTime dataEntrega = LocalDateTime.parse(sc.nextLine(), sdf);

        AluguelVeiculo car1 = new AluguelVeiculo(dataRetirada, dataEntrega, new Veiculo(carroModelo));

        System.out.print("Entre com o preço da hora: ");
        double precoDaHora = sc.nextDouble();
        System.out.print("Preço por dia: ");
        double precoPorDia = sc.nextDouble();

        ServicoDeAluguel servico = new ServicoDeAluguel(precoPorDia, precoDaHora, new BrasilTaxas());
        servico.processarFatura(car1);

        System.out.println("Fatura:");
        System.out.println("Pagamento basico: " + car1.getFatura().getPagamentoBasico());
        System.out.println("Imposto: " + car1.getFatura().getTaxas());
        System.out.println("Pagamento Total: " + car1.getFatura().getTotalPayment());

        sc.close();
    }
}
