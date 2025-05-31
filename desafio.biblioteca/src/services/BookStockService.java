package services;

import entities.Books;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookStockService {
    public static List<Books> reedBooks(){
        String patch = "C:\\temp\\books.csv";
        List<Books> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(patch))){
            String line = br.readLine();

            while (line != null){
                String[] itens = line.split(",");

                String title = itens[0];
                String author = itens[1];
                int ISBN = Integer.parseInt(itens[2]);
                int year = Integer.parseInt(itens[3]);
                int id = Integer.parseInt(itens[4]);

                books.add(new Books(title,author,ISBN, year, id));
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
