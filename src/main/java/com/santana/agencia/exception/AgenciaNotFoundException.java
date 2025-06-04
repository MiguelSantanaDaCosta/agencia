package com.santana.agencia.exception;

public class AgenciaNotFoundException extends RuntimeException {
    public AgenciaNotFoundException(Long id) {
        super("Agência não encontrada com id: " + id);
    }

    public AgenciaNotFoundException(String msg) {
        super(msg);
    }
}
