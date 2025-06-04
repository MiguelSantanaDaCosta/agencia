    package com.santana.agencia.repository;

    import com.santana.agencia.model.entity.Multa;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.stereotype.Repository;

    import java.time.LocalDate;
    import java.util.List;

    @Repository
    public interface MultaRepository extends JpaRepository<Multa, Long> {

        List<Multa> findByClienteId(Long clienteId);

        List<Multa> findByDataBetween(LocalDate inicio, LocalDate fim);

        @Query("SELECT SUM(m.valor) FROM Multa m WHERE m.cliente.id = :clienteId")
        Double calcularTotalMultasPorCliente(Long clienteId);

        @Query("SELECT SUM(m.valor) FROM Multa m WHERE m.data BETWEEN :inicio AND :fim")
        Double calcularTotalMultasPeriodo(LocalDate inicio, LocalDate fim);
    }