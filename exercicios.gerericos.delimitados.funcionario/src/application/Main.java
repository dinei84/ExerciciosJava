package application;

import entities.Employee;
import service.CalculationService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String patch = "C:\\temp\\employee.txt";

        List<Employee> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(patch))){
            String line = br.readLine();

            while (line != null){
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            Employee x = CalculationService.max(list);
            System.out.println("Most Salary:");
            System.out.println(x);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        sc.close();
    }
}