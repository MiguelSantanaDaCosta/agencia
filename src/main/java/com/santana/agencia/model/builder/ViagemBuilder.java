package com.santana.agencia.model.builder;

import com.santana.agencia.model.entity.*;
import java.time.LocalDate;

public class ViagemBuilder {
    private Viagem viagem;

    public ViagemBuilder() {
        this.viagem = new Viagem();
    }

    public ViagemBuilder comId(Long id) {
        viagem.setId(id);
        return this;
    }

    public ViagemBuilder comDestino(String destino) {
        viagem.setDestino(destino);
        return this;
    }

    public ViagemBuilder comPreco(double preco) {
        viagem.setPreco(preco);
        return this;
    }

    public ViagemBuilder comDataInicio(LocalDate dataInicio) {
        viagem.setDataInicio(dataInicio);
        return this;
    }

    public ViagemBuilder comDataFim(LocalDate dataFim) {
        viagem.setDataFim(dataFim);
        return this;
    }

    public ViagemBuilder comCliente(Cliente cliente) {
        viagem.setCliente(cliente);
        return this;
    }

    public ViagemBuilder comStatus(boolean status) {
        viagem.setStatus(status);
        return this;
    }

    public Viagem build() {
        return viagem;
    }
}
