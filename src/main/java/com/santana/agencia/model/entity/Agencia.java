package com.santana.agencia.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "agencia")
public class Agencia {
    private static Agencia instance;

    public static Agencia getInstance() {
    if (instance == null) {
        instance = new Agencia();
    }
    return instance;
}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cnpj;

    // Relacionamentos
    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cliente> clientes = new ArrayList<>();

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pacote> pacotes = new ArrayList<>();

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fornecedor> fornecedores = new ArrayList<>();

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Modal> modais = new ArrayList<>();

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Viagem> viagens = new ArrayList<>();

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compra> compras = new ArrayList<>();

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Passageiro> passageiros = new ArrayList<>();

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModalFornecedor> modalFornecedores = new ArrayList<>();

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Multa> multas = new ArrayList<>();

    // Construtores
    public Agencia() {
    }

    public Agencia(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    // Métodos de negócio (adaptados para JPA)
    public List<Cliente> listarClientesAtivos() {
        return clientes.stream()
                .filter(Cliente::isStatus)
                .collect(Collectors.toList());
    }


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
        return compras.stream()
                .mapToDouble(Compra::getValor)
                .sum();
    }

    public Double calcularFaturamentoPeriodo(LocalDate inicio, LocalDate fim) {
        return compras.stream()
                .filter(c -> {
                    LocalDate dataCompra = c.getData();
                    return dataCompra != null &&
                           !dataCompra.isBefore(inicio) &&
                           !dataCompra.isAfter(fim);
                })
                .mapToDouble(Compra::getValor)
                .sum();
    }

    private long contarClientesAtivos() {
        return clientes.stream()
                .filter(Cliente::isStatus)
                .count();
    }

    private long contarViagensDisponiveis() {
        return viagens.stream()
                .count();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Pacote> getPacotes() {
        return pacotes;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public List<Modal> getModais() {
        return modais;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public List<ModalFornecedor> getModalFornecedores() {
        return modalFornecedores;
    }

    public List<Multa> getMultas() {
        return multas;
    }
}
