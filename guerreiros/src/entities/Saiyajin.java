package entities;

public class Saiyajin extends Guerreiro {
    private String transformacao;
    private String origem;

    public Saiyajin(String nome, int vida, int poder, int defesa, String origem) {
        super(nome, vida, poder, defesa);
        this.transformacao = "Base";
        this.origem = origem;
    }

    public String getTransformacao() {
        return transformacao;
    }

    public void setTransformacao(String transformacao) {
        this.transformacao = transformacao;
    }

    public String getOrigem() {
        return origem;
    }

    public void transformarEmSuperSaiyajin() {
        if (!this.transformacao.startsWith("Super Saiyajin")) {
            System.out.println(getNome() + " começa a se transformar em Super Saiyajin!");
            this.setTransformacao("Super Saiyajin Nível 1");
            int aumentoPoder = (int) (getPoder() * 0.5); // Aumento de 50% no poder
            int aumentoDefesa = (int) (getDefesa() * 0.3); // Aumento de 30% na defesa
            super.sofrerDano(-aumentoPoder); // Aumenta o poder subtraindo dano negativo
            this.defesa += aumentoDefesa;
            System.out.println(getNome() + " alcançou a forma de " + getTransformacao() + "! Poder aumentado em " + aumentoPoder + ", Defesa aumentada em " + aumentoDefesa + ".");
        } else {
            System.out.println(getNome() + " já está transformado em " + getTransformacao() + ".");
        }
    }

    @Override
    public void poderEspecial(Guerreiro alvo) {
        System.out.println(getNome() + " concentra seu ki para um ataque especial de Saiyajin!");
        int danoBase = getPoder() * 3;
        int danoTransformacao = 0;
        if (transformacao.startsWith("Super Saiyajin")) {
            danoTransformacao = (int) (danoBase * 0.4); // Bônus de dano para Super Saiyajins
        }
        int danoTotal = danoBase + danoTransformacao - alvo.getDefesa();
        if (danoTotal < 0) {
            danoTotal = 0;
        }
        System.out.println(getNome() + " desfere um ataque devastador e causa " + danoTotal + " de dano!");
        alvo.sofrerDano(danoTotal);
    }
}
