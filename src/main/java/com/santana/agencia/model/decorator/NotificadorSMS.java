package com.santana.agencia.model.decorator;

public class NotificadorSMS extends NotificadorDecorator {
    public NotificadorSMS(Notificador wrappee) {
        super(wrappee);
    }

    @Override
    public void enviar(String destinatario, String mensagem) {
        // Lógica simulada de envio por SMS
        System.out.println("Enviando SMS para: " + destinatario);
        System.out.println("Conteúdo: " + mensagem);
        wrappee.enviar(destinatario, mensagem);
    }
}