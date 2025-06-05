package com.santana.agencia.model.singleton;

import com.santana.agencia.exception.CPFAlreadyExistsException;
import com.santana.agencia.exception.ClienteNotFoundException;
import com.santana.agencia.model.entity.Cliente;
import com.santana.agencia.repository.ClienteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Clientes {
    private static Clientes instance;
    private final ClienteRepository clienteRepository;

    @Autowired
    private Clientes(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public static synchronized Clientes getInstance(ClienteRepository clienteRepository) {
        if (instance == null) {
            instance = new Clientes(clienteRepository);
        }
        return instance;
    }

    @Transactional
    public void adicionarCliente(Cliente cliente) {
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new CPFAlreadyExistsException(cliente.getCpf());
        }
        clienteRepository.save(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException());
    }

    @Transactional
    public synchronized void removerCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}