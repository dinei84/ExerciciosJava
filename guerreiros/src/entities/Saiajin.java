package entities;

public class Saiajin extends Guerreiro{
    private int nivel;
    private String origem;


    public Saiajin(String raca, Double poderDeLuta, String golpeEspecial, int nivel, String origem, String nome) {
        super(raca, poderDeLuta, golpeEspecial, nome);

        this.nivel = nivel;
        this.origem = origem;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel() {
        this.nivel = nivel;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }


    public void trasnformacao(int nivel){
        this.nivel += 1;
    }

    @Override
    public String toString() {
        return "Saiajin: " +
                "\nNivel: " + nivel +
                "\nOrigem: " + origem;
    }
}
