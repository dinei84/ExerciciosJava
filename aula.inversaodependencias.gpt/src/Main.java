public class Main {
    public static void main(String[] args) {
        // Aqui escolhemos qual canal usar e injetamos
        CanalNotificacao canal = new Email(); // Pode trocar para Sms ou Whatsapp

        Notificador notificador = new Notificador(canal);
        notificador.notificar("Olá! Seu pedido foi confirmado.");

        // Mudando o canal dinamicamente (injeção nova)
        notificador = new Notificador(new Whatsapp());
        notificador.notificar("Você tem uma nova mensagem!");

        notificador = new Notificador(new Sms());
        notificador.notificar("SMS recebido");

    }
}