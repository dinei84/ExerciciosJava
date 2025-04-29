package application;

import entities.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> list = new ArrayList<>();
        String patch = "C:\\temp\\in.txt";


        try(BufferedReader br = new BufferedReader(new FileReader(patch))){

            String funcionarioCsv = br.readLine();
            while (funcionarioCsv != null){
                String[] campos = funcionarioCsv.split(",");
                list.add(new Funcionario(campos[0], Double.parseDouble(campos[1])));
                funcionarioCsv = br.readLine();
            }


            Collections.sort(list);
            for (Funcionario func : list){
                System.out.println(func.getNome() + ", " + func.getSalario());
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }


    }
}