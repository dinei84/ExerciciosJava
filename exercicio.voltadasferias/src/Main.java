import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Quantas notas vai adicionar?: ");
        int amount = sc.nextInt();
        sc.nextLine();

        float counter = 0;
        float media;

        for (int i = 0; i < amount; i ++){
            double score = 0;
            System.out.print("Digite a " + (i + 1) + "° nota: ");
            score = sc.nextDouble();


            if (score >= 0.0 && score <= 10.0){
                counter += score;
            }else {
                System.out.println("Nota invalida, tente novamente");
                i--;
            }

        }

        media = counter / (float)amount;

        System.out.println("-----------------------");
        System.out.printf("A media foi: %.2f", media);


        if (media >= 7){
            System.out.println();
            System.out.println( "Aprovado!");
        }else {
            System.out.println();
            System.out.println("Reprovado!");
        }


        sc.close();

    }
}