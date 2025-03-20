package entities;

public class Guerreiro {
    private String raca;
    private Double poderDeLuta;
    private String golpeEspecial;
    private String nome;


    public Guerreiro(String raca, Double poderDeLuta, String golpeEspecial, String nome) {
        this.raca = raca;
        this.poderDeLuta = poderDeLuta;
        this.golpeEspecial = golpeEspecial;
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Double getPoderDeLuta() {
        return poderDeLuta;
    }

    public void setPoderDeLuta(Double poderDeLuta) {
        this.poderDeLuta = poderDeLuta;
    }

    public String getGolpeEspecial() {
        return golpeEspecial;
    }

    public void setGolpeEspecial(String golpeEspecial) {
        this.golpeEspecial = golpeEspecial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Guerreiro: " +
                "\nNome: " + nome +
                "\nRaça: " + raca + '\'' +
                "\nPoderDeLuta: " + poderDeLuta +
                "\nGolpeEspecial: " + golpeEspecial ;
    }
}
