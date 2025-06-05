package com.santana.agencia.model.singleton;

import com.santana.agencia.model.entity.Pacote;
import com.santana.agencia.repository.PacoteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Pacotes {
    private static Pacotes instance;
    private final PacoteRepository pacoteRepository;

    @Autowired
    private Pacotes(PacoteRepository pacoteRepository) {
        this.pacoteRepository = pacoteRepository;
    }

    public static synchronized Pacotes getInstance(PacoteRepository pacoteRepository) {
        if (instance == null) {
            instance = new Pacotes(pacoteRepository);
        }
        return instance;
    }

    @Transactional
    public void adicionarPacote(Pacote pacote) {
        pacoteRepository.save(pacote);
    }

    @Transactional
    public void removerPacote(Pacote pacote) {
        pacoteRepository.delete(pacote);
    }

    @Transactional(readOnly = true)
    public List<Pacote> getPacotes() {
        return pacoteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Pacote> buscarPorDestino(String destino) {
        return pacoteRepository.findByDestinoContainingIgnoreCase(destino);
    }

    @Transactional(readOnly = true)
    public List<String> getDestinosDisponiveis() {
        return pacoteRepository.findDistinctDestinos();
    }
}