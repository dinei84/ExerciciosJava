package application;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Cliente {
    private String nome;
    private String email;
    private java.util.Date niver;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Cliente(){
    }

    public Cliente(String nome, String email, String dataNiver) throws ParseException {
        this.nome = nome;
        this.email = email;
        this.niver = sdf.parse(dataNiver); // Converte a String para Date
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNiver() {
        return new java.sql.Date(niver.getTime());
    }

    public void setNiver(Date niver) {
        this.niver = niver;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    // Removed setSdf method as sdf is a static final field and cannot be modified

    // @Override
    // public String toString() {
    //     return "Cliente [nome=" + nome + ", email=" + email + ", niver=" + sdf.format(niver);
    // }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Cliente: ");
        str.append("\nNome: " + nome);
        str.append("\nEmail: " + email);
        str.append("\nAniversario: " + sdf.format(niver));

        return str.toString();
    }

    
    
}   
