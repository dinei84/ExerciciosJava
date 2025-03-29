package entities;

public class Guerreiro {
    protected String nome;
    protected int vida;
    protected int poder;
    protected int defesa;

    public Guerreiro(String nome, int vida, int poder, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.poder = poder;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getPoder() {
        return poder;
    }

    public int getDefesa() {
        return defesa;
    }

    public void sofrerDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nome + " sofreu " + dano + " de dano. Vida restante: " + this.vida);
    }

    public void atacar(Guerreiro alvo){
        int dano = this.poder - alvo.getDefesa();
        if (dano < 0){
            dano = 0;
        }
        System.out.println(this.nome + " Ataca" + alvo.getNome() + " e causa" + dano + " de dano");
    }

    public int defender(){
        System.out.println(this.nome + " esta defendendo.");
        return this.defesa + (int) (Math.random() * 10);
    }

    public void poderEspecial(Guerreiro alvo) {
        System.out.println(this.nome + " usa um poder especial!");
        int dano = this.poder * 2 - alvo.getDefesa();
        if (dano < 0) {
            dano = 0;
        }
        System.out.println(this.nome + " causa " + dano + " de dano com seu poder especial!");
        alvo.sofrerDano(dano);
    }


}
