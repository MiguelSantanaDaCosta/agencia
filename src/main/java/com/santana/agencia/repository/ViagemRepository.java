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
    
    List<Viagem> findByVagasGreaterThan(int vagas);
    
    @Query("SELECT v FROM Viagem v WHERE v.preco <= :precoMax AND v.vagas > 0")
    List<Viagem> findDisponiveisPorPrecoMaximo(Double precoMax);
    
    @Query("SELECT DISTINCT v.destino FROM Viagem v")
    List<String> findDistinctDestinos();
}
