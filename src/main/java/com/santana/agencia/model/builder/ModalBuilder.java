package com.santana.agencia.model.builder;

import com.santana.agencia.model.entity.Modal;

public class ModalBuilder {
    private Modal modal;

    public ModalBuilder() {
        this.modal = new Modal();
    }

    public ModalBuilder comId(Long id) {
        modal.setId(id);
        return this;
    }

    public ModalBuilder comTipo(String tipo) {
        modal.setTipo(tipo);
        return this;
    }

    public ModalBuilder comPreco(double preco) {
        modal.setPreco(preco);
        return this;
    }

    public Modal build() {
        return modal;
    }
}