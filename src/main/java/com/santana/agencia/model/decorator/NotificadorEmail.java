package com.santana.agencia.model.decorator;

public class NotificadorEmail extends NotificadorDecorator {
    public NotificadorEmail(Notificador wrappee) {
        super(wrappee);
    }

    @Override
    public void enviar(String destinatario, String mensagem) {
        // Lógica simulada de envio por e-mail
        System.out.println("Enviando e-mail para: " + destinatario);
        System.out.println("Conteúdo: " + mensagem);
        wrappee.enviar(destinatario, mensagem); // Chama o próximo decorator/notificador
    }
}