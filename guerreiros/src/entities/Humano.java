package entities;

public class Humano extends Guerreiro {
    private String habilidadeEspecial;

    public Humano(String nome, int vida, int poder, int defesa, String habilidadeEspecial) {
        super(nome, vida, poder, defesa);
        this.habilidadeEspecial = habilidadeEspecial;
    }

    public String getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    @Override
    public void poderEspecial(Guerreiro alvo) {
        System.out.println(getNome() + " utiliza sua habilidade especial: " + habilidadeEspecial + "!");
        int dano = getPoder() * 2 + 15 - alvo.getDefesa(); // Habilidade especial com dano fixo bônus
        if (dano < 0) {
            dano = 0;
        }
        System.out.println(getNome() + " causa " + dano + " de dano com " + habilidadeEspecial + "!");
        alvo.sofrerDano(dano);
    }
}


