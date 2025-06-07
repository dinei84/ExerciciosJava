package services;

import entities.Books;
import entities.Member;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanService {
    private static final String PATH = "C:\\temp\\loans.txt";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // Alugar livro
    public static void rentBook(int ISBN, int memberId) {
        List<Books> books = BookStockService.readBooks();
        Books bookToRent = null;

        for (Books b : books) {
            if (b.getISBN() == ISBN) {
                bookToRent = b;
                break;
            }
        }

        if (bookToRent == null) {
            throw new RuntimeException("Book not found.");
        }

        if (bookToRent.getAmount() <= 0) {
            throw new RuntimeException("No book in stock.");
        }

        Member member = MemberService.findMemberById(memberId);
        if (member == null) {
            throw new RuntimeException("Member not found.");
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true))) {
            String line = String.join(",",
                    String.valueOf(ISBN),
                    String.valueOf(memberId),
                    sdf.format(new Date()));
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao registrar aluguel: " + e);
        }

        BookStockService.reduceBookAmount(ISBN, 1);
        System.out.println("Book rented successfully.");
    }

    // Listar empréstimos
    public static void listLoans() {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            System.out.println("Loan registerd:");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("Book ISBN: " + parts[0] + ", Member ID: " + parts[1] + ", Date: " + parts[2]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No loan registered.");
        } catch (IOException e) {
            throw new RuntimeException("Error listing loan: " + e);
        }
    }

    // Devolver livro
    public static void returnBook(int ISBN, int memberId) {
        List<String> loans = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[0]) == ISBN && Integer.parseInt(parts[1]) == memberId) {
                    found = true;  // Não adiciona à nova lista (remoção)
                } else {
                    loans.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing return: " + e);
        }

        if (!found) {
            System.out.println("Loan not found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))) {
            for (String loan : loans) {
                bw.write(loan);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error updating loans: " + e);
        }

        BookStockService.updateBookAmount(ISBN, BookStockService.readBooks().stream()
                .filter(b -> b.getISBN() == ISBN)
                .findFirst()
                .map(b -> b.getAmount() + 1)
                .orElse(1));

        System.out.println("Book returned successfully.");
    }
}
