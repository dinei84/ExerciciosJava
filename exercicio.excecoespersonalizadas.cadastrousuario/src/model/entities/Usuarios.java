package model.entities;

import model.exceptions.UsuarioException;

public class Usuarios {
    private String nome;
    private String senha;
    private String email;

    public Usuarios(String nome, String senha, String email) throws Exception {
        if (nome == null || nome.trim().isEmpty()){
            throw new Exception("Não pode ser vazio!");
        }
        if (senha == null || senha.length() < 6){
            throw new UsuarioException("A senha precisa ter mais de 6 digitos!");
        }

        if (email == null || !email.contains("@") || !email.contains(".")){
            throw new UsuarioException("Email precisa conter @ e . !");
        }
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuarios: " +
                "Nome: " + nome + " || " +
                " Senha='" + senha + " || "  +
                " Email='" + email + " || " +
                " " ;
    }
}
