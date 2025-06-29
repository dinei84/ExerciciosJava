package application;

import java.util.Locale;
import java.util.Scanner;
import services.PrintService;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        PrintService<Object> ps = new PrintService<>();

        System.out.print("How many values?: ");
        int quantity = sc.nextInt();


        for (int i = 0; i < quantity; i++) {
            System.out.print((i + 1) + "° " +"Value ");
            String value = sc.next();

            ps.addValue(value);
        }


        ps.print();
        Object x = ps.first();
        System.out.println("First: " + x);


        sc.close();
    }
}