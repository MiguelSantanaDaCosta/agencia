    package com.santana.agencia.repository;

    import com.santana.agencia.model.entity.Passageiro;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository
    public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {

        List<Passageiro> findByClienteId(Long clienteId);

        List<Passageiro> findByViagemId(Long viagemId);

        boolean existsByCpf(String cpf);

        long countByViagemId(Long viagemId);
    }
