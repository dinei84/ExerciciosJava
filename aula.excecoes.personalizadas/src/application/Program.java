package application;

import model.entities.Reservas;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Numero do quarto: ");
            int numero = sc.nextInt();
            sc.nextLine();
            System.out.print("Data do Check-in: ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Dara do Check-out: ");
            Date checkout = sdf.parse(sc.next());

            Reservas reserva = new Reservas(numero, checkIn, checkout);
            System.out.println("Reservas: " + reserva);

            System.out.println();
            System.out.println("Entre com a data atualizada: ");
            System.out.print("Data do Check-in: ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data do Check-out: ");
            checkout = sdf.parse(sc.next());

            reserva.atualizaData(checkIn, checkout);
            System.out.println("Reserva: " + reserva);

        }catch (ParseException e){
            System.out.println("Formato da data invalido!");
        }catch (DomainException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }




        sc.close();
    }

}
