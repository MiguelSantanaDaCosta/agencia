package com.santana.agencia.model.entity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;




public class Agencia {
    private static volatile Agencia instance;
    
    // Armazenamento thread-safe das entidades
    private final Map<Long, Cliente> clientes = new ConcurrentHashMap<>();
    private final Map<Long, Pacote> pacotes = new ConcurrentHashMap<>();
    private final Map<Long, Fornecedor> fornecedores = new ConcurrentHashMap<>();
    private final Map<Long, Modal> modais = new ConcurrentHashMap<>();
    private final Map<Long, Viagem> viagens = new ConcurrentHashMap<>();
    private final Map<Long, Compra> compras = new ConcurrentHashMap<>();
    private final Map<Long, Passageiro> passageiros = new ConcurrentHashMap<>();
    private final Map<Long, ModalFornecedor> modalFornecedores = new ConcurrentHashMap<>();
    private final Map<Long, Multa> multas = new ConcurrentHashMap<>();
    private String nome;
    private String cnpj;

    // Contadores de ID atômicos
    private final AtomicLong clienteIdCounter = new AtomicLong(1);
    private final AtomicLong pacoteIdCounter = new AtomicLong(1);
    private final AtomicLong fornecedorIdCounter = new AtomicLong(1);
    private final AtomicLong modalIdCounter = new AtomicLong(1);
    private final AtomicLong viagemIdCounter = new AtomicLong(1);
    private final AtomicLong compraIdCounter = new AtomicLong(1);
    private final AtomicLong passageiroIdCounter = new AtomicLong(1);
    private final AtomicLong modalFornecedorIdCounter = new AtomicLong(1);
    private final AtomicLong multaIdCounter = new AtomicLong(1);

    private Agencia() {
        // Inicialização básica se necessário
    }

    public static Agencia getInstance() {
        if (instance == null) {
            synchronized (Agencia.class) {
                if (instance == null) {
                    instance = new Agencia();
                }
            }
        }
        return instance;
    }

    // =============================================
    // MÉTODOS PARA CLIENTES
    // =============================================
    public Cliente adicionarCliente(Cliente cliente) {
        Objects.requireNonNull(cliente, "Cliente não pode ser nulo");
        long id = clienteIdCounter.getAndIncrement();
        cliente.setId(id);
        clientes.put(id, cliente);
        return cliente;
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return Optional.ofNullable(clientes.get(id));
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes.values());
    }

    public List<Cliente> listarClientesAtivos() {
        return clientes.values().stream()
                .filter(Cliente::isStatus)
                .collect(Collectors.toList());
    }

    public boolean removerCliente(Long id) {
        return clientes.remove(id) != null;
    }

    // =============================================
    // MÉTODOS PARA PACOTES
    // =============================================
    public Pacote adicionarPacote(Pacote pacote) {
        Objects.requireNonNull(pacote, "Pacote não pode ser nulo");
        long id = pacoteIdCounter.getAndIncrement();
        pacote.setId(id);
        pacotes.put(id, pacote);
        return pacote;
    }

    public Optional<Pacote> buscarPacotePorId(Long id) {
        return Optional.ofNullable(pacotes.get(id));
    }

    public List<Pacote> buscarPacotesPorDestino(String destino) {
        return pacotes.values().stream()
                .filter(p -> p.getDestino().equalsIgnoreCase(destino))
                .collect(Collectors.toList());
    }

    // =============================================
    // MÉTODOS PARA FORNECEDORES
    // =============================================
    public Fornecedor adicionarFornecedor(Fornecedor fornecedor) {
        Objects.requireNonNull(fornecedor, "Fornecedor não pode ser nulo");
        long id = fornecedorIdCounter.getAndIncrement();
        fornecedor.setId(id);
        fornecedores.put(id, fornecedor);
        return fornecedor;
    }

    public List<Fornecedor> listarFornecedoresPorTipo(String tipo) {
        return fornecedores.values().stream()
                .filter(f -> f.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    // =============================================
    // MÉTODOS PARA MODAIS
    // =============================================
    public Modal adicionarModal(Modal modal) {
        Objects.requireNonNull(modal, "Modal não pode ser nulo");
        long id = modalIdCounter.getAndIncrement();
        modal.setId(id);
        modais.put(id, modal);
        return modal;
    }

    // =============================================
    // MÉTODOS PARA VIAGENS
    // =============================================
    public Viagem adicionarViagem(Viagem viagem) {
        Objects.requireNonNull(viagem, "Viagem não pode ser nulo");
        long id = viagemIdCounter.getAndIncrement();
        viagem.setId(id);
        viagens.put(id, viagem);
        return viagem;
    }

    public List<Viagem> listarViagensDisponiveis() {
        return viagens.values().stream()
                .filter(v -> v.getVagas() > 0)
                .collect(Collectors.toList());
    }

    public boolean diminuirVagasViagem(Long viagemId) {
        Viagem viagem = viagens.get(viagemId);
        if (viagem != null && viagem.getVagas() > 0) {
            viagem.setVagas(viagem.getVagas() - 1);
            return true;
        }
        return false;
    }

    // =============================================
    // MÉTODOS PARA COMPRAS
    // =============================================
    public Compra registrarCompra(Compra compra) {
        Objects.requireNonNull(compra, "Compra não pode ser nula");
        long id = compraIdCounter.getAndIncrement();
        compra.setId(id);
        compras.put(id, compra);
        return compra;
    }

    // =============================================
    // MÉTODOS PARA PASSAGEIROS
    // =============================================
    public Passageiro adicionarPassageiro(Passageiro passageiro) {
        Objects.requireNonNull(passageiro, "Passageiro não pode ser nulo");
        long id = passageiroIdCounter.getAndIncrement();
        passageiro.setId(id);
        passageiros.put(id, passageiro);
        return passageiro;
    }

    // =============================================
    // MÉTODOS PARA MODAL_FORNECEDOR
    // =============================================
    public ModalFornecedor adicionarModalFornecedor(ModalFornecedor modalFornecedor) {
        Objects.requireNonNull(modalFornecedor, "ModalFornecedor não pode ser nulo");
        long id = modalFornecedorIdCounter.getAndIncrement();
        modalFornecedor.setId(id);
        modalFornecedores.put(id, modalFornecedor);
        return modalFornecedor;
    }

    // =============================================
    // MÉTODOS PARA MULTAS
    // =============================================
    public Multa registrarMulta(Multa multa) {
        Objects.requireNonNull(multa, "Multa não pode ser nula");
        long id = multaIdCounter.getAndIncrement();
        multa.setId(id);
        multas.put(id, multa);
        return multa;
    }

    // =============================================
    // MÉTODOS DE RELATÓRIOS E ESTATÍSTICAS
    // =============================================
    public Map<String, Object> gerarEstatisticas() {
        Map<String, Object> estatisticas = new HashMap<>();
        estatisticas.put("totalClientes", (long) clientes.size());
        estatisticas.put("totalViagens", (long) viagens.size());
        estatisticas.put("totalPacotes", (long) pacotes.size());
        estatisticas.put("faturamentoTotal", calcularFaturamentoTotal());
        estatisticas.put("clientesAtivos", contarClientesAtivos());
        estatisticas.put("viagensDisponiveis", contarViagensDisponiveis());
        return estatisticas;
    }

    public Double calcularFaturamentoTotal() {
        return compras.values().stream()
                .mapToDouble(Compra::getValor)
                .sum();
    }

    public Double calcularFaturamentoPeriodo(Date inicio, Date fim) {
        return compras.values().stream()
                .filter(c -> !c.getData().before(inicio) && !c.getData().after(fim))
                .mapToDouble(Compra::getValor)
                .sum();
    }

    private long contarClientesAtivos() {
        return clientes.values().stream()
                .filter(Cliente::isStatus)
                .count();
    }

    private long contarViagensDisponiveis() {
        return viagens.values().stream()
                .filter(v -> v.getVagas() > 0)
                .count();
    }

    // =============================================
    // MÉTODOS AUXILIARES
    // =============================================
    public void limparDados() {
        clientes.clear();
        pacotes.clear();
        fornecedores.clear();
        modais.clear();
        viagens.clear();
        compras.clear();
        passageiros.clear();
        modalFornecedores.clear();
        multas.clear();
        
        // Resetar contadores
        clienteIdCounter.set(1);
        pacoteIdCounter.set(1);
        fornecedorIdCounter.set(1);
        modalIdCounter.set(1);
        viagemIdCounter.set(1);
        compraIdCounter.set(1);
        passageiroIdCounter.set(1);
        modalFornecedorIdCounter.set(1);
        multaIdCounter.set(1);
    }

    // Getter e setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e setter para cnpj
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
