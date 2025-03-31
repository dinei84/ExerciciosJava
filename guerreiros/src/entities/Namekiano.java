package entities;

public class Namekiano extends Guerreiro {
    private boolean capacidadeRegeneracao;

    public Namekiano(String nome, int vida, int poder, int defesa, boolean capacidadeRegeneracao) {
        super(nome, vida, poder, defesa);
        this.capacidadeRegeneracao = capacidadeRegeneracao;
    }

    public boolean getCapacidadeRegeneracao() {
        return capacidadeRegeneracao;
    }

    public void regenerar() {
        if (capacidadeRegeneracao) {
            int vidaRegenerada = getPoder() * 2;
            super.sofrerDano(-vidaRegenerada); // Cura o Namekiano
            System.out.println(getNome() + " utiliza sua capacidade de regeneração e recupera " + vidaRegenerada + " de vida.");
        } else {
            System.out.println(getNome() + " não possui a capacidade de regeneração.");
        }
    }

    @Override
    public void poderEspecial(Guerreiro alvo) {
        System.out.println(getNome() + " concentra sua energia Namekiana!");
        int dano = getPoder() * 2 + 10 - alvo.getDefesa();
        if (dano < 0) {
            dano = 0;
        }
        System.out.println(getNome() + " atinge " + alvo.getNome() + " com uma poderosa onda de energia, causando " + dano + " de dano!");
        alvo.sofrerDano(dano);
    }
}
