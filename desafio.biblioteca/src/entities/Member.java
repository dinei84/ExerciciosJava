package entities;

import services.Loan;

public class Member {
    private String name;
    private String email;
    private Integer id;
    private Loan loan;

    public Member(String name, String email, Integer id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addLoan(){

    }
    public void removeLoan(){

    }
    public void listLoan(){

    }
}
