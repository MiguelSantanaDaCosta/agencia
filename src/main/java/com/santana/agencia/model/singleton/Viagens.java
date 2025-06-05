package com.santana.agencia.model.singleton;

import com.santana.agencia.model.entity.Viagem;
import java.util.ArrayList;
import java.util.List;

public class Viagens {
    private static Viagens instance;
    private final List<Viagem> viagens;

    private Viagens() {
        this.viagens = new ArrayList<>();
    }

    public static synchronized Viagens getInstance() {
        if (instance == null) {
            instance = new Viagens();
        }
        return instance;
    }

    public void adicionarViagem(Viagem viagem) {
        viagens.add(viagem);
    }

    public void removerViagem(Viagem viagem) {
        viagens.remove(viagem);
    }

    public List<Viagem> getViagens() {
        return new ArrayList<>(viagens);
    }

    public List<Viagem> buscarPorDestino(String destino) {
        return viagens.stream()
                .filter(v -> v.getDestino().equalsIgnoreCase(destino))
                .toList();
    }

    public List<Viagem> buscarViagensDisponiveis() {
        return viagens.stream()
                .toList();
    }
}
