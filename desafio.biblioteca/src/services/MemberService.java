package services;

import entities.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private static final String PATCH = "C:\\temp\\members.txt";

    //Adicionar um membro
    public static void addMember(Member member){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATCH, true))){
            String line = String.join(",",
                    member.getName(),
                    member.getEmail(),
                    String.valueOf(member.getId()));
            bw.write(line);
            bw.newLine();
        } catch (Exception e) {
            throw new RuntimeException("Error to save the member: " + e.getMessage());
        }
    }

    //Listar membros
    public static List<Member> readMembers(){
        List<Member> members = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATCH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] items = line.split(",");
                if (items.length == 3) {
                    String name = items[0];
                    String email = items[1];
                    Integer id = Integer.parseInt(items[2]);
                    members.add(new Member(name, email, id));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading members: " + e.getMessage());
        }
        return members;
    }

    //Buscar membro por ID
    public static Member findMemberById(int id){
        List<Member> members = readMembers();
        for (Member member : members){
            if (member.getId() == id){
                return member;
            }
        }
        return null;
    }

    //Excluir membro por ID
    public static void deleteMemberById(int id){
        List<Member> members = readMembers();
        boolean removed = members.removeIf(member -> member.getId() == id);

        if (!removed){
            System.out.println("Member with ID " + id + " not found.");
        }
        saveMembers(members);
        System.out.println("Member with ID " + id + " has been removed.");
    }

    //Salvar membros atualizados
    private static void saveMembers(List<Member> members) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATCH))) {
            for (Member member : members) {
                String line = String.join(",",
                        member.getName(),
                        member.getEmail(),
                        String.valueOf(member.getId()));
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar membros: " + e);
        }
    }


}
