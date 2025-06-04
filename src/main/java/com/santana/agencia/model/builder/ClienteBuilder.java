package com.santana.agencia.model.builder;

import com.santana.agencia.model.entity.Cliente;

public class ClienteBuilder {
    private Cliente cliente;

    public ClienteBuilder() {
        this.cliente = new Cliente();
    }

    public ClienteBuilder comId(Long id) {
        cliente.setId(id);
        return this;
    }

    public ClienteBuilder comNome(String nome) {
        cliente.setNome(nome);
        return this;
    }

    public ClienteBuilder comEmail(String email) {
        cliente.setEmail(email);
        return this;
    }

    public ClienteBuilder comCpf(String cpf) {
        cliente.setCpf(cpf);
        return this;
    }

    public ClienteBuilder comEndereco(String endereco) {
        cliente.setEndereco(endereco);
        return this;
    }

    public ClienteBuilder comTelefone(String telefone) {
        cliente.setTelefone(telefone);
        return this;
    }

    public ClienteBuilder comStatus(boolean status) {
        cliente.setStatus(status);
        return this;
    }

    public Cliente build() {
        return cliente;
    }
}
