package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        String[] lines = new String[]{"Começo","Bom dia","Boa tarde","Boa noite", "Tchau", "oi "};

        String path = "c:\\temp\\out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){// quando adicionamos o true, estou dizendo que não queremos recriar o arquivo e sim sobrescrever
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
