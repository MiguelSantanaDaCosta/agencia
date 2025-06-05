package com.santana.agencia.model.singleton;

import com.santana.agencia.model.entity.Modal;
import com.santana.agencia.repository.ModalRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;    
import java.util.List;
import java.util.Optional;

@Service
public class Modais {
    private static Modais instance;
    private final ModalRepository modalRepository;

    @Autowired
    private Modais(ModalRepository modalRepository) {
        this.modalRepository = modalRepository;
    }

    public static synchronized Modais getInstance(ModalRepository modalRepository) {
        if (instance == null) {
            instance = new Modais(modalRepository);
        }
        return instance;
    }

    @Transactional
    public Modal adicionarModal(Modal modal) {
        return modalRepository.save(modal);
    }

    @Transactional
    public void removerModal(Long id) {
        modalRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Modal> getModais() {
        return modalRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Modal buscarPorTipo(String tipo) {
        return modalRepository.findByTipoIgnoreCase(tipo)
                .orElseThrow(() -> new RuntimeException("Modal do tipo " + tipo + " não encontrado"));
    }

    @Transactional(readOnly = true)
    public List<String> getTiposDisponiveis() {
        return modalRepository.findDistinctTipos();
    }

    @Transactional(readOnly = true)
    public boolean existeModalDoTipo(String tipo) {
        return modalRepository.findByTipoIgnoreCase(tipo).isPresent();
    }
}