/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santana.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santana.agencia.model.entity.ModalFornecedor;
import com.santana.agencia.repository.ModalFornecedorRepository;

/**
 *
 * ModalFornecedorService
 */
@Service
public class ModalFornecedorService {

  @Autowired
  private ModalFornecedorRepository modalFornecedorRepository;

  public ModalFornecedor salvar(ModalFornecedor cliente) {
    return modalFornecedorRepository.save(cliente);
  }

  public List<ModalFornecedor> listarTodos() {
    return modalFornecedorRepository.findAll();
  }
  
  public Optional<ModalFornecedor> buscarPorId(Long id) {
    return modalFornecedorRepository.findById(id);
  }

  public List<ModalFornecedor> listarPorFornecedorId(Long id) {
    return modalFornecedorRepository.findByFornecedorId(id);
  }

  public List<ModalFornecedor> listarPorModalId(Long id) {
    return modalFornecedorRepository.findByModalId(id);
  }

  public List<ModalFornecedor> buscarPorFaixaDePreco(Double precoMin, Double precoMax) {

    return modalFornecedorRepository.findByPrecoBetween(precoMin, precoMax);
  }
  
  public ModalFornecedor atualizar(Long id, ModalFornecedor clienteAtualizado) {
    clienteAtualizado.setId(id);
    return modalFornecedorRepository.save(clienteAtualizado);
  }
  
  public void deletar(Long id) {
    modalFornecedorRepository.deleteById(id);
  }

}
