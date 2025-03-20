package entities;

public class Humanos extends Guerreiro{
    private String mestre;

    public Humanos(String raca, Integer poderDeLuta, String golpeEspecial, String nome, String mestre) {
        super(raca, poderDeLuta, golpeEspecial, nome);
        this.mestre = mestre;
    }

    public String getMestre() {
        return mestre;
    }

    public void setMestre(String mestre) {
        this.mestre = mestre;
    }

    @Override
    public String toString() {
        return "\n" +
            "\nGuerreiro: " + 
            "\nNome: " + this.getNome() +
            "\nRaça: " + this.getRaca() +
            "\nPoder de Luta: " + this.getPoderDeLuta() +
            "\nGolpe especial: " + this.getGolpeEspecial() + 
            "\nMestre: " + mestre;
    }

    



}
