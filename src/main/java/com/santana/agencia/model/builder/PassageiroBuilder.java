package com.santana.agencia.model.builder;

import com.santana.agencia.model.entity.Passageiro;
import java.time.LocalDate;

public class PassageiroBuilder {
    private Passageiro passageiro;

    public PassageiroBuilder() {
        this.passageiro = new Passageiro();
    }

    public PassageiroBuilder comId(Long id) {
        passageiro.setId(id);
        return this;
    }

    public PassageiroBuilder comNome(String nome) {
        passageiro.setNome(nome);
        return this;
    }

    public PassageiroBuilder comCpf(String cpf) {
        passageiro.setCpf(cpf);
        return this;
    }

    public PassageiroBuilder comDataNascimento(LocalDate dataNascimento) {
        passageiro.setDataNascimento(dataNascimento);
        return this;
    }

    public PassageiroBuilder comTelefone(String telefone) {
        passageiro.setTelefone(telefone);
        return this;
    }

    public PassageiroBuilder comEmail(String email) {
        passageiro.setEmail(email);
        return this;
    }

    public PassageiroBuilder comStatus(boolean status) {
        passageiro.setStatus(status);
        return this;
    }

    public Passageiro build() {
        return passageiro;
    }
}
