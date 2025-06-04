package com.santana.agencia.model.entity;

import jakarta.persistence.*;

@Entity
public class ModalFornecedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tipo;
    private double preco;
    private String nomeFornecedor;
    
    @ManyToOne
    @JoinColumn(name = "modal_id")
    private Modal modal;

    @OneToOne
    private Agencia agencia;
    
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public Modal getModal() {
        return modal;
    }

    public void setModal(Modal modal) {
        this.modal = modal;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    // Método toString() para facilitar a visualização
    @Override
    public String toString() {
        return "ModalFornecedor{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", preco=" + preco +
                ", nomeFornecedor='" + nomeFornecedor + '\'' +
                '}';
    }
}
