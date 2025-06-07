package services;

import entities.Books;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookStockService {

    public static List<Books> readBooks(){
        String patch = "C:\\temp\\books.txt";
        List<Books> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(patch))){            ;
            String line;
            while ((line = br.readLine()) != null){
                String[] itens = line.split(",");

                if (itens.length == 5) {
                    String title = itens[0];
                    String author = itens[1];
                    int ISBN = Integer.parseInt(itens[2]);
                    int year = Integer.parseInt(itens[3]);
                    int id = Integer.parseInt(itens[4]);

                    books.add(new Books(title,author,ISBN, year, id));
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquivo não encontrado" + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return books;
    }


    //Metodo para adicionar livros a partir de um arquivo CSV
    public static void addBook(Books book){
        String patch = "C:\\temp\\books.txt";

        try(BufferedWriter br =  new BufferedWriter(new FileWriter(patch, true))){
            String line = String .join(",",
                    book.getTitle(),
                    book.getAuthor(),
                    String.valueOf(book.getISBN()),
                    String.valueOf(book.getYear()),
                    String.valueOf(book.getAmount()));
            br.write(line);
            br.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error to save the book" + e);
        }
    }

    // Metodo para atualizar a quantidade de livros
    public static void updateBookAmount(int ISBN, int newAmount) {
        boolean found = false;
        List<Books> books = readBooks();

        for (Books book : books) {
            if (book.getISBN() == ISBN) {
                book.setAmount(newAmount);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("Book with ISBN " + ISBN + " not found.");
        }
        saveBooks(books);
        System.out.println("Book amount updated successfully.");
    }

    // Metodo para salvar a lista de livros no arquivo CSV
    public static void saveBooks(List<Books> books) {
        String patch = "C:\\temp\\books.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch))) {
            for (Books book : books) {
                String line = String.join(",",
                        book.getTitle(),
                        book.getAuthor(),
                        String.valueOf(book.getISBN()),
                        String.valueOf(book.getYear()),
                        String.valueOf(book.getAmount()));
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar os livros no arquivo.", e);
        }
    }

    //Metodo para reduzir a quantidade de livros
    public static List<Books> reduceBookAmount(int ISBN, int amountToReduce) {
        List<Books> books = readBooks();
        boolean found = false;

        for (Books book : books) {
            if (book.getISBN() == ISBN) {
                int newAmount = book.getAmount() - amountToReduce;
                if (newAmount < 0) {
                    throw new RuntimeException("Cannot reduce amount below zero.");
                }
                book.setAmount(newAmount);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new RuntimeException("Book with ISBN " + ISBN + " not found.");
        }

        saveBooks(books);
        System.out.println("Book amount reduced successfully.");

        return books;
    }

    //Metodo para excluir um livro
    public static void deleteBook(int ISBN) {
        List<Books> books = readBooks();
        boolean found = false;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getISBN() == ISBN) {
                books.remove(i);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new RuntimeException("Book with ISBN " + ISBN + " not found.");
        }

        saveBooks(books);
        System.out.println("Book deleted successfully.");
    }

}
