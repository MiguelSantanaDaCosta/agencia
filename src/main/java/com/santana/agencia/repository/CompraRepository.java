package com.santana.agencia.repository;

import com.santana.agencia.model.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    
    List<Compra> findByClienteId(Long clienteId);
    
    List<Compra> findByDataBetween(LocalDate inicio, LocalDate fim);
    
    @Query("SELECT SUM(c.valor) FROM Compra c WHERE c.cliente.id = :clienteId")
    Double calcularTotalComprasPorCliente(Long clienteId);
    
    @Query("SELECT c FROM Compra c WHERE c.status = :status")
    List<Compra> findByStatus(String status);
}