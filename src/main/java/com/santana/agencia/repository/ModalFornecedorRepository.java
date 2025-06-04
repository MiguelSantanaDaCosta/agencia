package com.santana.agencia.repository;

import com.santana.agencia.model.entity.ModalFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModalFornecedorRepository extends JpaRepository<ModalFornecedor, Long> {
    
    List<ModalFornecedor> findByFornecedorId(Long fornecedorId);
    
    List<ModalFornecedor> findByModalId(Long modalId);
    
    @Query("SELECT mf FROM ModalFornecedor mf WHERE mf.preco BETWEEN :precoMin AND :precoMax")
    List<ModalFornecedor> findByPrecoBetween(Double precoMin, Double precoMax);
    
    boolean existsByFornecedorIdAndModalId(Long fornecedorId, Long modalId);
}