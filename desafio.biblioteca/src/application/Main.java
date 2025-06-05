package application;

import entities.Books;
import entities.Member;
import services.BookStockService;
import services.LoanService;
import services.MemberService;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static int menu(Scanner sc) {
        System.out.println("Welcome to the Book Stock Management System!");
        System.out.println("Please choose an option:");
        System.out.println("1. View all books");
        System.out.println("2. Rent a book");
        System.out.println("3. Add a book");
        System.out.println("4. View all members");
        System.out.println("5. Add a member");
        System.out.println("6. Rent a book");
        System.out.println("7. Return a book");
        System.out.println("0. Exit");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int option = menu(sc);

        while (option != 0) {
            switch (option) {
                case 1:
                    List<Books> booksList = BookStockService.readBooks();
                    System.out.println("Tamanho da lista: " + booksList.size());

                    if (booksList.isEmpty()) {
                        System.out.println("Nothing book found");
                    } else {
                        System.out.println("Books found");
                        System.out.println("-----------------------");
                        for (Books book : booksList) {
                            System.out.println("Título:     " + book.getTitle());
                            System.out.println("Autor:      " + book.getAuthor());
                            System.out.println("ISBN:       " + book.getISBN());
                            System.out.println("Ano:        " + book.getYear());
                            System.out.println("Quantidade: " + book.getAmount());
                            System.out.println("--------------------------------------------------");
                        }
                    }
                    menu(sc);
                    break;

                case 2:
                    // Implementar lógica para alugar um livro

                    break;

                case 3:
                    //implementar lógica para adicionar um livro
                    break;
                case 4:
                    List<Member> members = MemberService.readMembers();
                    for (Member m : members) {
                        System.out.println("Nome: " + m.getName() + ", Email: " + m.getEmail() + ", ID: " + m.getId());
                    }
                    break;

                case 5:
                    System.out.print("Digite o nome do membro: ");
                    String name = sc.nextLine();
                    System.out.print("Digite o email: ");
                    String email = sc.nextLine();
                    System.out.print("Digite o ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    MemberService.addMember(new Member(name, email, id));
                    break;

                case 6:
                    System.out.print("Digite o ISBN do livro: ");
                    int isbnRent = sc.nextInt();
                    System.out.print("Digite o ID do membro: ");
                    int memberId = sc.nextInt();
                    LoanService.rentBook(isbnRent, memberId);
                    break;

                case 7:
                    System.out.print("Digite o ISBN do livro: ");
                    int isbnReturn = sc.nextInt();
                    System.out.print("Digite o ID do membro: ");
                    int memberIdReturn = sc.nextInt();
                    LoanService.returnBook(isbnReturn, memberIdReturn);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
            option = menu(sc);
        }

        System.out.println("Exiting the Book Stock Management System. Goodbye!");
        sc.close();
    }
}