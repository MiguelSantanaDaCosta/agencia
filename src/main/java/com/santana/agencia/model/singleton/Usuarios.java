package com.santana.agencia.model.singleton;

import com.santana.agencia.model.entity.Cliente;
import com.santana.agencia.model.entity.Usuario;
import com.santana.agencia.repository.ClienteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Usuarios {
    private static Usuarios instance;
    private final ClienteRepository clienteRepository; // Repositório concreto

    @Autowired
    private Usuarios(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public static synchronized Usuarios getInstance(ClienteRepository clienteRepository) {
        if (instance == null) {
            instance = new Usuarios(clienteRepository);
        }
        return instance;
    }

    @Transactional
    public void adicionarUsuario(Usuario usuario) {
        if (usuario instanceof Cliente cliente) {
            if (clienteRepository.existsByEmail(cliente.getEmail())) {
                throw new RuntimeException("Email já cadastrado");
            }
            clienteRepository.save(cliente);
        } else {
            throw new UnsupportedOperationException("Tipo de usuário não suportado");
        }
    }

    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return new ArrayList<>(clienteRepository.findAll()); // Upcast para Usuario
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}