package com.santana.agencia.model.singleton;

import com.santana.agencia.model.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private static Usuarios instance;
    private final List<Usuario> usuarios;

    private Usuarios() {
        this.usuarios = new ArrayList<>();
    }

    public static synchronized Usuarios getInstance() {
        if (instance == null) {
            instance = new Usuarios();
        }
        return instance;
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
}
