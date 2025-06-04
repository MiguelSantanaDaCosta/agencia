    package com.santana.agencia.repository;

    import com.santana.agencia.model.entity.Pacote;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository
    public interface PacoteRepository extends JpaRepository<Pacote, Long> {

        List<Pacote> findByDestino(String destino);

        List<Pacote> findByOrigem(String origem);

        List<Pacote> findByStatusTrue();

        @Query("SELECT p FROM Pacote p WHERE p.preco <= :precoMax")
        List<Pacote> findByPrecoMenorOuIgual(Double precoMax);

        @Query("SELECT DISTINCT p.destino FROM Pacote p")
        List<String> findDistinctDestinos();
    }
