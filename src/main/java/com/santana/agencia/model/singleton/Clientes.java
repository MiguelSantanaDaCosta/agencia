package com.santana.agencia.model.singleton;

import com.santana.agencia.model.entity.Cliente;
import java.util.ArrayList;
import java.util.List;

public class Clientes {

    private static Clientes instance;
    private final List<Cliente> clientes;

    private Clientes() {
        this.clientes = new ArrayList<>();
    }

    public static synchronized Clientes getInstance() {
        if (instance == null) {
            instance = new Clientes();
        }
        return instance;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes); // Retorna cópia para evitar modificações externas
    }

    public Cliente buscarPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void limparClientes() {
        clientes.clear();
    }
}
