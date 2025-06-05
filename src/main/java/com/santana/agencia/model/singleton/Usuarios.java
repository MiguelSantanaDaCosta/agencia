package com.santana.agencia.model.singleton;

import com.santana.agencia.model.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class Usuarios {
    private static Usuarios instance;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private Usuarios(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public static synchronized Usuarios getInstance(UsuarioRepository usuarioRepository) {
        if (instance == null) {
            instance = new Usuarios(usuarioRepository);
        }
        return instance;
    }

    @Transactional
    public void adicionarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        usuarioRepository.save(usuario);
    }

    @Transactional
    public void removerUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}