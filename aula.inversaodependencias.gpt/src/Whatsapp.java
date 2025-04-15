public class Whatsapp implements CanalNotificacao{
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando WhatsApp: " + mensagem);
    }
}
