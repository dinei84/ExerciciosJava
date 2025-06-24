import entities.Client;

public class Main {
    public static void main(String[] args) {
//    String a = "Dinei";
//    String b = "Fernanda";

//    System.out.println(a.equals(b));

//    String c = "Maria";
//    String d = "Alex";
//
//    System.out.println(c.hashCode());
//    System.out.println(d.hashCode());

        Client c1 = new Client("Fernanda", "dinei@dinei.com");
        Client c2 = new Client("Fernanda", "fer@fer.com");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

        System.out.println(c1.equals(c2));



    }
}