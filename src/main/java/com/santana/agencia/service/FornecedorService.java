package com.santana.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santana.agencia.model.entity.Fornecedor;
import com.santana.agencia.repository.FornecedorRepository;

/**
 * FornecedorService
 */
@Service
public class FornecedorService {

  @Autowired
  private FornecedorRepository fornecedorRepository;

  public Fornecedor salvar(Fornecedor fornecedor) {
    return fornecedorRepository.save(fornecedor);
  }

  public List<Fornecedor> listarTodos() {
    return fornecedorRepository.findAll();
  }
  
  public Optional<Fornecedor> buscarPorId(Long id) {
    return fornecedorRepository.findById(id);
  }
  
  public Fornecedor atualizar(Long id, Fornecedor clienteAtualizado) {
    clienteAtualizado.setId(id);
    return fornecedorRepository.save(clienteAtualizado);
  }
  
  public void deletar(Long id) {
    fornecedorRepository.deleteById(id);
  }
}

