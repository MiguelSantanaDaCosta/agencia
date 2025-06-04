package com.santana.agencia.model.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String tipo;
    private boolean status;
    
    @OneToOne
    private Agencia agencia;

    @OneToMany(mappedBy = "fornecedor")
    private List<ModalFornecedor> modais;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<ModalFornecedor> getModais() {
        return modais;
    }

    public void setModais(List<ModalFornecedor> modais) {
        this.modais = modais;
    }
}
