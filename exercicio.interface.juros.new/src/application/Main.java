package application;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.ServicoContrato;
import model.services.ServicoPaypal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Dados do Contrato");
        System.out.print("Numero do contrato: ");
        Integer numero = sc.nextInt();

        System.out.print("Data e hora (dd/MM/yyyy) ");
        Date data = sdf.parse(sc.next());

        System.out.print("Valor total: ");
        Double valorTotal = sc.nextDouble();

        System.out.print("Numero de parcelas: ");
        int parcelas = sc.nextInt();
        sc.hasNextLine();

        Contrato contrato1 = new Contrato(numero, data, valorTotal);


        ServicoContrato servicoContrato = new ServicoContrato(contrato1, new ServicoPaypal());
        servicoContrato.processandoContrato(contrato1, parcelas);

        for (Parcela parcela : contrato1.getParcelas()){
            System.out.println("Parcelas: " + parcela);
        }









        sc.close();
    }
}