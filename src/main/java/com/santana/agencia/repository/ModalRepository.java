        package com.santana.agencia.repository;

        import com.santana.agencia.model.entity.Modal;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import org.springframework.data.jpa.repository.Query;

        @Repository
        public interface ModalRepository extends JpaRepository<Modal, Long> {

            List<Modal> findByTipo(String tipo);

            @Query("SELECT DISTINCT m.tipo FROM Modal m")
            List<String> findDistinctTipos();
        }
