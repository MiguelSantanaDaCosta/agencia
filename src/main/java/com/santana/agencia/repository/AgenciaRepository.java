  package com.santana.agencia.repository;

import com.santana.agencia.model.entity.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

    // Busca pelo CNPJ único
    Optional<Agencia> findByCnpj(String cnpj);

    // Consultas para estatísticas
    @Query("SELECT COUNT(c) FROM Cliente c")
    Long countClientes();

    @Query("SELECT COUNT(v) FROM Viagem v")
    Long countViagens();

       @Query("SELECT COUNT(p) FROM Pacote p")
    Long countPacotes();

    @Query("SELECT SUM(c.valor) FROM Compra c")
    Double calcularFaturamentoTotal();

    // Verificação de CNPJ único para atualização
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
           "FROM Agencia a WHERE a.cnpj = :cnpj AND a.id <> :id")
    boolean existsByCnpjAndNotId(@Param("cnpj") String cnpj, @Param("id") Long id);

    // Consulta para verificar se a agência principal existe
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
           "FROM Agencia a WHERE a.id = 1")
    boolean existsAgenciaPrincipal();

    // Consulta para obter o faturamento por período
    @Query("SELECT SUM(c.valor) FROM Compra c WHERE c.data BETWEEN :dataInicio AND :dataFim")
    Optional<Double> calcularFaturamentoPeriodo(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

    // Consulta para contar clientes ativos
    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.status = true")
    Long countClientesAtivos();

    // Método correto para verificar existência de CNPJ
    boolean existsByCnpj(String cnpj);
}
