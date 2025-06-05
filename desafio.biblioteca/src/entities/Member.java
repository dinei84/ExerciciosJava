package entities;


public class Member {
    private String name;
    private String email;
    private Integer id;


    public Member(String name, String email, Integer id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
