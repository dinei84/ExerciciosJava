package entities;

public class Namecuseijin extends Guerreiro{
    private int idade;
    private String abilidade;
    private Integer fundir;


    public Namecuseijin(String raca, Integer poderDeLuta, String golpeEspecial, int idade, String abilidade, String nome) {
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

    public int getFundir() {
        return fundir;
    }
    public void setFundir(Integer fundir) {
        setPoderDeLuta(fundir);
        this.fundir = fundir + 10000;
    }

    @Override
    public String toString() {
        return "\n" +
            "\nGuerreiro: " + 
            "\nNome: " + this.getNome() +
            "\nRaça: " + this.getRaca() +
            "\nPoder de Luta: " + this.getPoderDeLuta() +
            "\nGolpe especial: " + this.getGolpeEspecial() +
            "\nIdade: " + idade + 
            "\nAbilidade: " + abilidade + 
            "\nFundir: " + fundir;
    }

    
}
