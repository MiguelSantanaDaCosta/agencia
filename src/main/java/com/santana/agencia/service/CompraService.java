    package com.santana.agencia.service;

    import com.santana.agencia.model.decorator.*;
    import com.santana.agencia.model.entity.Compra;
    import com.santana.agencia.model.entity.Cliente;
    import com.santana.agencia.repository.CompraRepository;
    import com.santana.agencia.repository.ClienteRepository;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    @Service
    public class CompraService {
        private final CompraRepository compraRepository;
        private final ClienteRepository clienteRepository;
        private final Notificador notificador;

        public CompraService(CompraRepository compraRepository, 
                            ClienteRepository clienteRepository) {
            this.compraRepository = compraRepository;
            this.clienteRepository = clienteRepository;
            this.notificador = new NotificadorEmail( // Configuração básica
                             new NotificadorBase());
        }

        @Transactional
        public Compra registrarCompra(Compra compra) {
            Compra compraSalva = compraRepository.save(compra);
            enviarNotificacoes(compraSalva);
            return compraSalva;
        }

        private void enviarNotificacoes(Compra compra) {
            Cliente cliente = clienteRepository.findById(compra.getCliente().getId())
                              .orElseThrow();

            // Notificação para o cliente
            String mensagemCliente = String.format(
                "Olá %s, sua compra no valor de R$%.2f foi registrada com sucesso!",
                cliente.getNome(), 
                compra.getValor());

            notificador.enviar(cliente.getEmail(), mensagemCliente);

            // Notificação para a agência (email fixo ou configurável)
            String mensagemAgencia = String.format(
                "Nova compra registrada: Cliente %s, Valor: R$%.2f, Data: %s",
                cliente.getNome(),
                compra.getValor(),
                compra.getData().toString());

            notificador.enviar("agencia@suporte.com", mensagemAgencia);
        }
    }