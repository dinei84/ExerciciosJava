import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        System.out.print("How many values?: ");
        int quantity = sc.nextInt();

        for (int i = 0; i < quantity; i++) {
            System.out.print("Number " + (i + 1) + "° ");
            int number = sc.nextInt();
            sc.nextLine();

            list.add(number);
        }


        for (int value : list){
            System.out.println(value);
        }





        sc.close();
    }
}