package com.santana.agencia.model.builder;

import com.santana.agencia.model.entity.ModalFornecedor;

public class ModalFornecedorBuilder {
    private ModalFornecedor modalFornecedor;

    public ModalFornecedorBuilder() {
        this.modalFornecedor = new ModalFornecedor();
    }

    public ModalFornecedorBuilder comId(Long id) {
        modalFornecedor.setId(id);
        return this;
    }

    public ModalFornecedorBuilder comTipo(String tipo) {
        modalFornecedor.setTipo(tipo);
        return this;
    }

    public ModalFornecedorBuilder comPreco(double preco) {
        modalFornecedor.setPreco(preco);
        return this;
    }

    public ModalFornecedorBuilder comNomeFornecedor(String nomeFornecedor) {
        modalFornecedor.setNomeFornecedor(nomeFornecedor);
        return this;
    }

    public ModalFornecedor build() {
        return modalFornecedor;
    }
}