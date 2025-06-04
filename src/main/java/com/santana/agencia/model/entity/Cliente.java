package com.santana.agencia.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente extends Usuario  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String cpf;
    
    private String endereco;
    private String telefone;

    @OneToOne
    private Agencia agencia;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Passageiro> passageiros;
    
    @OneToMany(mappedBy = "cliente")
    private List<Viagem> viagens;
    
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
    
    @OneToMany(mappedBy = "cliente")
    private List<Multa> multas;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public void setMultas(List<Multa> multas) {
        this.multas = multas;
    }
}
