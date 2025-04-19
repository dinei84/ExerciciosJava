package application;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.ServicoContrato;
import model.services.ServicoPaypal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");


        Contrato obj = new Contrato(8022, sdf.parse("15/04/2025 10:30"), 600.0);

        ServicoContrato servicoContrato = new ServicoContrato(obj, new ServicoPaypal());
        servicoContrato.processandoContrato(obj, 3);

        for (Parcela parcela : obj.getParcelas()){
            System.out.println("Parcelas: " + parcela);
        }









        sc.close();
    }
}