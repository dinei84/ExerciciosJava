package entities;

public class Saiajin extends Guerreiro{
    private int nivel;
    private String origem;


    public Saiajin(String raca, Integer poderDeLuta, String golpeEspecial, int nivel, String origem, String nome) {
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
        if (nivel == 1) {
            this.setPoderDeLuta((int)(this.getPoderDeLuta() + 50000.0));
            System.out.println("SupeSaiajin nivel 1");
        }else if (nivel == 2) {
            this.setPoderDeLuta((int)(this.getPoderDeLuta() + 60000.0));
            System.out.println("SupeSaiajin nivel 2");
        }else if (nivel == 3) {
            this.setPoderDeLuta((int)(this.getPoderDeLuta() + 70000.0));
            System.out.println("SuperSaiajin nivel 3");
        }
    }

    @Override
    public String toString() {
        return "\n" +
            "\nGuerreiro: " + 
            "\nNome: " + this.getNome() +
            "\nRaça: " + this.getRaca() +
            "\nPoder de Luta: " + this.getPoderDeLuta() +
            "\nGolpe especial: " + this.getGolpeEspecial() +
            "\nNivel: " + nivel +
            "\nOrigem: " + origem;
    }
}
