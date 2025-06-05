package com.santana.agencia.repository;

import com.santana.agencia.model.entity.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {
    
    List<Viagem> findByDestino(String destino);
    
    List<Viagem> findByClienteId(Long clienteId);
    
    List<Viagem> findByDataInicioBetween(LocalDate inicio, LocalDate fim);
    
    @Query("SELECT DISTINCT v.destino FROM Viagem v")
    List<String> findDistinctDestinos();
}
