package com.santana.agencia.model.decorator;

public class NotificadorBase implements Notificador {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("[Notificador Base] Registrando mensagem no log: " + mensagem);
    }

    @Override
    public String getTipo() {
        return "BASE";
    }
}