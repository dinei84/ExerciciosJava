public class Notificador {
    private CanalNotificacao canal;

    // Injeção de dependencia via contrutor
    public Notificador(CanalNotificacao canal){
        this.canal = canal;
    }

    public void notificar(String mensagem){
        canal.enviarMensagem(mensagem);
    }
}
