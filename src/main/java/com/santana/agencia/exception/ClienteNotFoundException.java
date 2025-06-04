package com.santana.agencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException() {
        super("Cliente não encontrado");
    }
}
