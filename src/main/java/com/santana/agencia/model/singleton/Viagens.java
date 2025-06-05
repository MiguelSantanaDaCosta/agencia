package com.santana.agencia.model.singleton;

import com.santana.agencia.model.entity.Viagem;
import com.santana.agencia.repository.ViagemRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Viagens {
    private static Viagens instance;
    private final ViagemRepository viagemRepository;

    @Autowired
    private Viagens(ViagemRepository viagemRepository) {
        this.viagemRepository = viagemRepository;
    }

    public static synchronized Viagens getInstance(ViagemRepository viagemRepository) {
        if (instance == null) {
            instance = new Viagens(viagemRepository);
        }
        return instance;
    }

    @Transactional
    public void adicionarViagem(Viagem viagem) {
        viagemRepository.save(viagem);
    }

    @Transactional(readOnly = true)
    public List<Viagem> getViagens() {
        return viagemRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Viagem> buscarViagensDisponiveis() {
        return viagemRepository.findByVagasGreaterThan(0);
    }

    @Transactional
    public synchronized boolean diminuirVagas(Long viagemId) {
        Viagem viagem = viagemRepository.findById(viagemId)
                .orElseThrow(() -> new RuntimeException("Viagem não encontrada"));
        
        if (viagem.getVagas() > 0) {
            viagem.setVagas(viagem.getVagas() - 1);
            viagemRepository.save(viagem);
            return true;
        }
        return false;
    }
}
