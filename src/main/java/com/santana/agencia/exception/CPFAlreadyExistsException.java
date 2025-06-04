package com.santana.agencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class CPFAlreadyExistsException extends RuntimeException {
    public CPFAlreadyExistsException(String cpf) {
        super("Já existe um cliente cadastrado com seu cpf" + cpf);
    }
    
    public CPFAlreadyExistsException(String cpf, Throwable cause) {
        super("Já existe um cliente cadastrado com seu cpf" + cpf, cause);
    }
}
