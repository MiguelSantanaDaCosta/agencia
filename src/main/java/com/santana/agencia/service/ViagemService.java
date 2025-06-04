    package com.santana.agencia.service;

    import java.util.List;
    import java.util.Optional;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import com.santana.agencia.model.entity.Viagem;
    import com.santana.agencia.repository.ViagemRepository;

    /**
     * ViagemService
     */
    @Service
    public class ViagemService {

      @Autowired
      private ViagemRepository viagemRepository;

      public Viagem salvar(Viagem cliente) {
        return viagemRepository.save(cliente);
      }

      public List<Viagem> listarTodos() {
        return viagemRepository.findAll();
      }

      public List<Viagem> listarPorCliente(Long clienteId) {
        return viagemRepository.findByClienteId(clienteId);
      }

      public Optional<Viagem> buscarPorId(Long id) {
        return viagemRepository.findById(id);
      }

      public Viagem atualizar(Long id, Viagem clienteAtualizado) {
        clienteAtualizado.setId(id);
        return viagemRepository.save(clienteAtualizado);
      }

      public void deletar(Long id) {
        viagemRepository.deleteById(id);
      }

    }

