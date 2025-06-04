package com.santana.agencia.model.builder;

import com.santana.agencia.model.entity.Pacote;

public class PacoteBuilder {
    private Pacote pacote;

    public PacoteBuilder() {
        this.pacote = new Pacote();
    }

    public PacoteBuilder comId(Long id) {
        pacote.setId(id);
        return this;
    }

    public PacoteBuilder comDestino(String destino) {
        pacote.setDestino(destino);
        return this;
    }

    public PacoteBuilder comOrigem(String origem) {
        pacote.setOrigem(origem);
        return this;
    }

    public PacoteBuilder comPreco(double preco) {
        pacote.setPreco(preco);
        return this;
    }

    public PacoteBuilder comStatus(boolean status) {
        pacote.setStatus(status);
        return this;
    }

    public Pacote build() {
        return pacote;
    }
}
