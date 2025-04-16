package application;

import model.entities.Contrato;
import model.services.ServicoContrato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");


        Contrato obj = new Contrato(8022, sdf.parse("15/04/2025"), 600.0);

        ServicoContrato service = new ServicoContrato(8022, )









        sc.close();
    }
}