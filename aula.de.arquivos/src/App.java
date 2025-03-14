import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        File file = new File("C:\\temp\\in");
        Scanner sc = null;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }

        finally{
            if (sc != null) {
                sc.close();    
            }            
        }
    }
}
