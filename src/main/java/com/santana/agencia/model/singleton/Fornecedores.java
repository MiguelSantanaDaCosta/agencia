package com.santana.agencia.model.singleton;

import com.santana.agencia.model.entity.Fornecedor;
import java.util.ArrayList;
import java.util.List;

public class Fornecedores {
    private static Fornecedores instance;
    private final List<Fornecedor> fornecedores;

    private Fornecedores() {
        this.fornecedores = new ArrayList<>();
    }

    public static synchronized Fornecedores getInstance() {
        if (instance == null) {
            instance = new Fornecedores();
        }
        return instance;
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public void removerFornecedor(Fornecedor fornecedor) {
        fornecedores.remove(fornecedor);
    }

    public List<Fornecedor> getFornecedores() {
        return new ArrayList<>(fornecedores);
    }

    public List<Fornecedor> buscarPorTipo(String tipo) {
        return fornecedores.stream()
                .filter(f -> f.getTipo().equalsIgnoreCase(tipo))
                .toList();
    }
}
