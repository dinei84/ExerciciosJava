package application;

import entities.Books;
import services.BookStockService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Book Stock Management System!");
        System.out.println("Please choose an option:");
        System.out.println("1. View all books");
        System.out.println("2. Rent a books");
        System.out.println("3. To add a book");
        System.out.println("0. Exit");
        int option = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (option != 0) {
            switch (option) {
                case 1:
                    List<Books> booksList = BookStockService.readBooks();

                    if (booksList.isEmpty()){
                        System.out.println("Noting book found");
                    }
                    System.out.println("Book´s found");
                    System.out.println("-----------------------");

                    for (Books book : booksList){
                        System.out.println("Título:     " + book.getTitle());
                        System.out.println("Autor:      " + book.getAuthor());
                        System.out.println("ISBN:       " + book.getISBN());
                        System.out.println("Ano:        " + book.getYear());
                        System.out.println("Quantidade: " + book.getAmount());
                        System.out.println("--------------------------------------------------");
                    }
                    break;
                case 2:
                    // Here you would call the method to view all books

                    break;
                case 3:
                    System.out.println("Enter book title:");
                    String title = sc.nextLine();
                    System.out.println("Enter book author:");
                    String author = sc.nextLine();
                    System.out.println("Enter book ISBN:");
                    int isbn = sc.nextInt();
                    System.out.println("Enter book year:");
                    int year = sc.nextInt();
                    System.out.println("Enter book amount:");
                    int amount = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    // Here you would call the method to add the book
                    BookStockService.addBook(new Books(title, author, isbn, year, amount));
                    System.out.println("Book added successfully!");

                    break;



                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println("Please choose an option:");
            option = sc.nextInt();
            sc.nextLine(); // Consume the newline character
        }


        sc.close();
    }
}