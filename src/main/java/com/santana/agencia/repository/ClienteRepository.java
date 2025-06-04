package com.santana.agencia.repository;

import com.santana.agencia.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    Optional<Cliente> findByCpf(String cpf);
    
    List<Cliente> findByStatusTrue();
    
    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.status = true")
    Long countClientesAtivos();
    
    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END " +
           "FROM Cliente c WHERE c.email = :email")
    boolean existsByEmail(String email);
    
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END " +
           "FROM Cliente c WHERE c.cpf = :cpf")
    boolean existsByCpf(String cpf);
}
