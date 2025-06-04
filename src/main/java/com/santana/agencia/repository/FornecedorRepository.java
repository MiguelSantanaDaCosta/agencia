package com.santana.agencia.repository;

import com.santana.agencia.model.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    
    List<Fornecedor> findByTipo(String tipo);
    
    List<Fornecedor> findByStatusTrue();
    
    @Query("SELECT DISTINCT f.tipo FROM Fornecedor f")
    List<String> findDistinctTipos();
    
    @Query("SELECT f FROM Fornecedor f WHERE LOWER(f.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Fornecedor> findByNomeContainingIgnoreCase(String nome);
}
