package com.santana.agencia.model.builder;

import com.santana.agencia.model.entity.Compra;
import java.time.LocalDate;

public class CompraBuilder {
    private Compra compra;

    public CompraBuilder() {
        this.compra = new Compra();
    }

    public CompraBuilder comId(Long id) {
        compra.setId(id);
        return this;
    }

    public CompraBuilder comData(LocalDate data) {
        compra.setData(data);
        return this;
    }

    public CompraBuilder comValor(double valor) {
        compra.setValor(valor);
        return this;
    }

    public CompraBuilder comStatus(String status) {
        compra.setStatus(status);
        return this;
    }

    public Compra build() {
        return compra;
    }
}
