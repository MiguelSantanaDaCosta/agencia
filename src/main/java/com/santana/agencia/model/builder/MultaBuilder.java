package com.santana.agencia.model.builder;

import com.santana.agencia.model.entity.Multa;
import java.time.LocalDate;

public class MultaBuilder {
    private Multa multa;

    public MultaBuilder() {
        this.multa = new Multa();
    }

    public MultaBuilder comId(Long id) {
        multa.setId(id);
        return this;
    }

    public MultaBuilder comValor(double valor) {
        multa.setValor(valor);
        return this;
    }

    public MultaBuilder comMotivo(String motivo) {
        multa.setMotivo(motivo);
        return this;
    }

    public MultaBuilder comData(LocalDate data) {
        multa.setData(data);
        return this;
    }

    public Multa build() {
        return multa;
    }
}
