public class Email implements CanalNotificacao{
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }
}
