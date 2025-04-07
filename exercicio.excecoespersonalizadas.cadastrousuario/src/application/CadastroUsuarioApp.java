package application;

import model.entities.Usuarios;
import model.exceptions.UsuarioException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroUsuarioApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Usuarios> usuario = new ArrayList<>();



        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print("Escolha: 1=(Cadastrar) / 2=(Sair) ");
                String escolha = sc.nextLine();

                switch (escolha) {
                    case "1":
                        System.out.print("Quantos usuários deseja cadastrar? ");
                        int numero = Integer.parseInt(sc.nextLine());

                        for (int i = 0; i < numero; i++) {
                            System.out.print("Nome do Usuário: ");
                            String nome = sc.nextLine();

                            System.out.print("Senha do Usuário: ");
                            String senha = sc.nextLine();

                            System.out.print("Email do Usuário: ");
                            String email = sc.nextLine();

                            usuario.add(new Usuarios(nome, senha, email));
                        }
                        break;

                    case "2":
                        continuar = false;
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida. Certifique-se de inserir um número válido.");
            } catch (UsuarioException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }

        }



        System.out.println("Usuarios: ");
        for (Usuarios usuarios : usuario){
            System.out.println(usuarios);
        }


        sc.close();
    }
}
