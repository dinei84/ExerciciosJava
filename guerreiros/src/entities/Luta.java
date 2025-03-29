package entities;

import java.util.List;
import java.util.Scanner;


public class Luta {
    private String jogador1;
    private String jogador2;
    private Guerreiro personagemJogador1;
    private Guerreiro personagemJogador2;
    private Scanner scanner;

    public Luta(String jogador1, String jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.scanner = new Scanner(System.in);
    }

    public void escolherPersonagens(List<Guerreiro> personagensDisponiveis) {
        System.out.println("\n" + jogador1 + ", escolha seu personagem:");
        exibirPersonagensDisponiveis(personagensDisponiveis);
        personagemJogador1 = selecionarPersonagem(personagensDisponiveis);

        System.out.println("\n" + jogador2 + ", escolha seu personagem:");
        exibirPersonagensDisponiveis(personagensDisponiveis);
        personagemJogador2 = selecionarPersonagem(personagensDisponiveis);

        System.out.println("\n" + jogador1 + " escolheu " + personagemJogador1.getNome() + ".");
        System.out.println(jogador2 + " escolheu " + personagemJogador2.getNome() + ".");
    }

    private void exibirPersonagensDisponiveis(List<Guerreiro> personagens) {
        for (int i = 0; i < personagens.size(); i++) {
            System.out.println((i + 1) + ". " + personagens.get(i).getNome());
        }
    }

    private Guerreiro selecionarPersonagem(List<Guerreiro> personagens) {
        int escolha = -1;
        while (escolha < 1 || escolha > personagens.size()) {
            System.out.print("Digite o número do personagem desejado: ");
            try {
                escolha = scanner.nextInt();
                if (escolha < 1 || escolha > personagens.size()) {
                    System.out.println("Escolha inválida. Digite um número da lista.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next(); // Limpa o scanner
            }
        }
        return personagens.get(escolha - 1);
    }

    public void iniciarLuta() {
        System.out.println("\n--- Iniciando a Luta! ---");
        Guerreiro atacante = personagemJogador1;
        Guerreiro defensor = personagemJogador2;

        while (!verificarFimLuta()) {
            System.out.println("\n--- Turno de " + atacante.getNome() + " (" + (atacante == personagemJogador1 ? jogador1 : jogador2) + ") ---");
            realizarTurno(atacante, defensor);

            // Troca os lutadores para o próximo turno
            Guerreiro temp = atacante;
            atacante = defensor;
            defensor = temp;
        }

        exibirResultado();
    }

    private void realizarTurno(Guerreiro atacante, Guerreiro defensor) {
        int opcao = exibirOpcoes(atacante);
        aplicarAcao(opcao, atacante, defensor);
    }

    private int exibirOpcoes(Guerreiro personagem) {
        int escolha = -1;
        while (escolha < 1 || escolha > (personagem instanceof Saiyajin ? 4 : 3)) { // Saiyajins têm transformação
            System.out.println("Escolha uma ação:");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Poder Especial");
            if (personagem instanceof Saiyajin) {
                System.out.println("4. Transformar em Super Saiyajin");
            }
            System.out.print("Digite o número da sua escolha: ");
            try {
                escolha = scanner.nextInt();
                int maxOpcao = (personagem instanceof Saiyajin ? 4 : 3);
                if (escolha < 1 || escolha > maxOpcao) {
                    System.out.println("Opção inválida. Digite um número da lista.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next(); // Limpa o scanner
            }
        }
        return escolha;
    }

    private void aplicarAcao(int opcao, Guerreiro atacante, Guerreiro defensor) {
        switch (opcao) {
            case 1:
                atacante.atacar(defensor);
                break;
            case 2:
                int defesa = atacante.defender();
                System.out.println(atacante.getNome() + " aumentou sua defesa para " + defesa + " neste turno.");
                break;
            case 3:
                atacante.poderEspecial(defensor);
                break;
            case 4:
                if (atacante instanceof Saiyajin) {
                    ((Saiyajin) atacante).transformarEmSuperSaiyajin();
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private boolean verificarFimLuta() {
        return personagemJogador1.getVida() <= 0 || personagemJogador2.getVida() <= 0;
    }

    private void exibirResultado() {
        System.out.println("\n--- Fim da Luta! ---");
        if (personagemJogador1.getVida() <= 0 && personagemJogador2.getVida() <= 0) {
            System.out.println("Empate! Ambos os guerreiros foram derrotados.");
        } else if (personagemJogador1.getVida() <= 0) {
            System.out.println(personagemJogador2.getNome() + " (" + jogador2 + ") venceu a luta!");
        } else {
            System.out.println(personagemJogador1.getNome() + " (" + jogador1 + ") venceu a luta!");
        }
    }
}
