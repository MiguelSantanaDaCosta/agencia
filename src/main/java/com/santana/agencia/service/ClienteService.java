    package com.santana.agencia.service;

    import java.util.List;
    import java.util.Optional;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import com.santana.agencia.exception.CPFAlreadyExistsException;
import com.santana.agencia.exception.ClienteNotFoundException;
import com.santana.agencia.model.entity.Cliente;
    import com.santana.agencia.repository.ClienteRepository;

    /**
     * ClienteService
     */
    @Service
    public class ClienteService {

      @Autowired
      private ClienteRepository clienteRepository;

      public Cliente salvar(Cliente cliente) {
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
          throw new CPFAlreadyExistsException(cliente.getCpf());
        }
        return clienteRepository.save(cliente);
      }

      public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
      }

      public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
      }

      public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> clienteAchado = clienteRepository.findById(id);
        if (clienteAchado.isEmpty()) {
          throw new ClienteNotFoundException();
        }
        clienteAtualizado.setId(id);
        clienteAtualizado.setCpf(clienteAchado.get().getCpf());
        return clienteRepository.save(clienteAtualizado);
      }

      public void deletar(Long id) {
        clienteRepository.deleteById(id);
      }
    }

