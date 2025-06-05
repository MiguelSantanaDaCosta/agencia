        package com.santana.agencia.repository;

        import com.santana.agencia.model.entity.Modal;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Optional;
        import org.springframework.data.jpa.repository.Query;

       @Repository
public interface ModalRepository extends JpaRepository<Modal, Long> {
    Optional<Modal> findByTipoIgnoreCase(String tipo); // Deve retornar Optional
    
    @Query("SELECT DISTINCT m.tipo FROM Modal m")
    List<String> findDistinctTipos();
}
        
