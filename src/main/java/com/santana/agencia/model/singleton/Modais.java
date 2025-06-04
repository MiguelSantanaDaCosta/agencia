package com.santana.agencia.model.singleton;

import com.santana.agencia.model.entity.Modal;
import java.util.ArrayList;
import java.util.List;

public class Modais {
    private static Modais instance;
    private final List<Modal> modais;

    private Modais() {
        this.modais = new ArrayList<>();
    }

    public static synchronized Modais getInstance() {
        if (instance == null) {
            instance = new Modais();
        }
        return instance;
    }

    public void adicionarModal(Modal modal) {
        modais.add(modal);
    }

    public void removerModal(Modal modal) {
        modais.remove(modal);
    }

    public List<Modal> getModais() {
        return new ArrayList<>(modais);
    }

    public Modal buscarPorTipo(String tipo) {
        return modais.stream()
                .filter(m -> m.getTipo().equalsIgnoreCase(tipo))
                .findFirst()
                .orElse(null);
    }
}
