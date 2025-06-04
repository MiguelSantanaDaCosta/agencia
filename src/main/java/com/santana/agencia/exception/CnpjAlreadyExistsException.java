package com.santana.agencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class CnpjAlreadyExistsException extends RuntimeException {
    public CnpjAlreadyExistsException(String cnpj) {
        super("Já existe uma agência cadastrada com o CNPJ: " + cnpj);
    }
    
    public CnpjAlreadyExistsException(String cnpj, Throwable cause) {
        super("Já existe uma agência cadastrada com o CNPJ: " + cnpj, cause);
    }
}
