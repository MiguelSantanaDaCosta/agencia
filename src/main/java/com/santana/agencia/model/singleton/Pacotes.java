package com.santana.agencia.model.singleton;

import com.santana.agencia.model.entity.Pacote;
import java.util.ArrayList;
import java.util.List;

public class Pacotes {
    private static Pacotes instance;
    private final List<Pacote> pacotes;

    private Pacotes() {
        this.pacotes = new ArrayList<>();
    }

    public static synchronized Pacotes getInstance() {
        if (instance == null) {
            instance = new Pacotes();
        }
        return instance;
    }

    public void adicionarPacote(Pacote pacote) {
        pacotes.add(pacote);
    }

    public void removerPacote(Pacote pacote) {
        pacotes.remove(pacote);
    }

    public List<Pacote> getPacotes() {
        return new ArrayList<>(pacotes);
    }

    public List<Pacote> buscarPorDestino(String destino) {
        return pacotes.stream()
                .filter(p -> p.getDestino().equalsIgnoreCase(destino))
                .toList();
    }
}
