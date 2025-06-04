            package com.santana.agencia.service;

        
        import com.santana.agencia.exception.AgenciaNotFoundException;
        import com.santana.agencia.exception.CnpjAlreadyExistsException;
        import com.santana.agencia.model.entity.Agencia;
        import com.santana.agencia.repository.AgenciaRepository;
        import org.springframework.dao.DataIntegrityViolationException;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        import java.util.List;
        
        
        
        
        
        @Service
        public class AgenciaService {
            
            private final AgenciaRepository agenciaRepository;

            public AgenciaService(AgenciaRepository agenciaRepository) {
                this.agenciaRepository = agenciaRepository;
            }

            @Transactional(readOnly = true)
            public List<Agencia> listarTodos() {
                return agenciaRepository.findAll();
            }

            @Transactional(readOnly = true)
            public Agencia buscarPorId(Long id) {
                return agenciaRepository.findById(id)
                        .orElseThrow(() -> new AgenciaNotFoundException(id));
            }

            @Transactional(readOnly = true)
            public Agencia buscarPorCnpj(String cnpj) {
                return agenciaRepository.findByCnpj(cnpj)
                        .orElseThrow(() -> new AgenciaNotFoundException("Agência não encontrada com CNPJ: " + cnpj));
            }

            @Transactional
            public Agencia salvar(Agencia agencia) {
                if (agenciaRepository.existsByCnpj(agencia.getCnpj())) {
                    throw new CnpjAlreadyExistsException(agencia.getCnpj());
                }
                return agenciaRepository.save(agencia);
            }

            @Transactional
            public Agencia atualizar(Long id, Agencia agenciaAtualizada) {
                return agenciaRepository.findById(id)
                        .map(agencia -> {
                            if (!agencia.getCnpj().equals(agenciaAtualizada.getCnpj())) {
                                if (agenciaRepository.existsByCnpjAndNotId(agenciaAtualizada.getCnpj(), id)) {
                                    throw new CnpjAlreadyExistsException(agenciaAtualizada.getCnpj());
                                }
                            }
                            agencia.setNome(agenciaAtualizada.getNome());
                            agencia.setCnpj(agenciaAtualizada.getCnpj());
                            return agenciaRepository.save(agencia);
                        })
                        .orElseThrow(() -> new AgenciaNotFoundException(id));
            }

            @Transactional
            public void deletar(Long id) {
                try {
                    if (!agenciaRepository.existsById(id)) {
                        throw new AgenciaNotFoundException(id);
                    }
                    agenciaRepository.deleteById(id);
                } catch (DataIntegrityViolationException e) {
                    throw new IllegalStateException("Não é possível excluir a agência pois existem entidades relacionadas");
                }
            }

            
             @Transactional(readOnly = true)
             public Agencia obterEstatisticas() {
               return Agencia.getInstance();
              }

              @Transactional(readOnly = true)
              public Double obterFaturamentoPeriodo(java.time.LocalDate inicio, java.time.LocalDate fim) {
                return Agencia.getInstance().calcularFaturamentoPeriodo(inicio, fim);
               }


            @Transactional(readOnly = true)
            public Agencia obterAgenciaPrincipal() {
                return agenciaRepository.findById(1L)
                        .orElseThrow(() -> new AgenciaNotFoundException("Agência principal não configurada"));
            }

            @Transactional
            public Agencia atualizarAgenciaPrincipal(String nome, String cnpj) {
                Agencia agencia = obterAgenciaPrincipal();
                if (!agencia.getCnpj().equals(cnpj)) {
                    if (agenciaRepository.existsByCnpj(cnpj)) {
                        throw new CnpjAlreadyExistsException(cnpj);
                    }
                }
                agencia.setNome(nome);
                agencia.setCnpj(cnpj);
                return agenciaRepository.save(agencia);
            }

            @Transactional(readOnly = true)
            public boolean verificarDisponibilidadeCnpj(String cnpj) {
                return !agenciaRepository.existsByCnpj(cnpj);
            }
        }   
