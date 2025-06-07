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
            throw new RuntimeException("Livro não encontrado.");
        }

        if (bookToRent.getAmount() <= 0) {
            throw new RuntimeException("Livro sem estoque.");
        }

        Member member = MemberService.findMemberById(memberId);
        if (member == null) {
            throw new RuntimeException("Membro não encontrado.");
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
        System.out.println("Livro alugado com sucesso.");
    }

    // Listar empréstimos
    public static void listLoans() {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            System.out.println("Empréstimos registrados:");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("Livro ISBN: " + parts[0] + ", Membro ID: " + parts[1] + ", Data: " + parts[2]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum empréstimo registrado.");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao listar empréstimos: " + e);
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
            throw new RuntimeException("Erro ao processar devolução: " + e);
        }

        if (!found) {
            System.out.println("Empréstimo não encontrado.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))) {
            for (String loan : loans) {
                bw.write(loan);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao atualizar empréstimos: " + e);
        }

        BookStockService.updateBookAmount(ISBN, BookStockService.readBooks().stream()
                .filter(b -> b.getISBN() == ISBN)
                .findFirst()
                .map(b -> b.getAmount() + 1)
                .orElse(1));

        System.out.println("Livro devolvido com sucesso.");
    }
}
