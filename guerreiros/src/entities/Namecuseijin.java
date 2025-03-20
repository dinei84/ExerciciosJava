package entities;

public class Namecuseijin extends Guerreiro{
    private int idade;
    private String abilidade;


    public Namecuseijin(String raca, Double poderDeLuta, String golpeEspecial, int idade, String abilidade, String nome) {
        super(raca, poderDeLuta, golpeEspecial, nome);

        this.idade = idade;
        this.abilidade = abilidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAbilidade() {
        return abilidade;
    }

    public void setAbilidade(String abilidade) {
        this.abilidade = abilidade;
    }



    public void conjurarEsferas(){
        System.out.println("Esferas Criadas!!!");
    }
}
