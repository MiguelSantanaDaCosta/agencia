package com.santana.agencia.model.builder;

import com.santana.agencia.model.entity.Fornecedor;

public class FornecedorBuilder {
    private Fornecedor fornecedor;

    public FornecedorBuilder() {
        this.fornecedor = new Fornecedor();
    }

    public FornecedorBuilder comId(Long id) {
        fornecedor.setId(id);
        return this;
    }

    public FornecedorBuilder comNome(String nome) {
        fornecedor.setNome(nome);
        return this;
    }

    public FornecedorBuilder comTipo(String tipo) {
        fornecedor.setTipo(tipo);
        return this;
    }

    public FornecedorBuilder comStatus(boolean status) {
        fornecedor.setStatus(status);
        return this;
    }

    public Fornecedor build() {
        return fornecedor;
    }
}
