package try_catch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        metodo1();
        System.out.println("Fim");



    }

    public static void metodo1() {
        System.out.println("Metodo 1 Start");
        metodo2();
        System.out.println("Fim Metodo 1");
    }

    public static void metodo2() {
        System.out.println("Metodo 2 Start");
        Scanner sc = new Scanner(System.in);

        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Fora da posição!");
            e.printStackTrace();
            sc.next();
        }
        catch (InputMismatchException e ){
            System.out.println("Erro de input");
        }

        System.out.println("Fim Metodo 2");

        sc.close();
    }
}
