package com.santana.agencia.model.decorator;

public abstract class NotificadorDecorator implements Notificador {
    protected final Notificador wrappee;

    public NotificadorDecorator(Notificador wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public abstract void enviar(String destinatario, String mensagem);

    @Override
    public String getTipo() {
        return wrappee.getTipo() + " -> " + this.getClass().getSimpleName();
    }
}