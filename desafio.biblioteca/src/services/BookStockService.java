package services;

import entities.Books;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookStockService {

    public static List<Books> readBooks(){
        String patch = "C:\\temp\\books.csv";
        List<Books> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(patch))){
            String line = br.readLine();

            while (line != null){
                String[] itens = line.split(",");

                if (itens.length < 5) {
                    String title = itens[0];
                    String author = itens[1];
                    int ISBN = Integer.parseInt(itens[2]);
                    int year = Integer.parseInt(itens[3]);
                    int id = Integer.parseInt(itens[4]);

                    books.add(new Books(title,author,ISBN, year, id));
                    line = br.readLine();
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return books;
    }

    public static List<Books> addBooks(){
        String patch = "C:\\temp\\books.csv";
        List<Books> addBooks = new ArrayList<>();

        try (BufferedWriter br = new BufferedWriter(new FileWriter(patch))){
            String[] line = br.readLine();

            while (line != null){
                String[] itens = line.split(",");

                String title = itens[0];
                String author = itens[1];
                int ISBN = Integer.parseInt(itens[2]);
                int year = Integer.parseInt(itens[3]);
                int id = Integer.parseInt(itens[4]);

                addBooks.add(new Books(title,author,ISBN, year, id));
                line = br.readLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return addBooks;
    }


}
