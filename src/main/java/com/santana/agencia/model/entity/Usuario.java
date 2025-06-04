package com.santana.agencia.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import jakarta.validation.constraints.Email;

@MappedSuperclass
public abstract class Usuario {
    @Column(nullable = false)
    private String nome;
    
    @Email(message = "Email deve ser válido")
    @Column(unique = true, nullable = false)
    private String email;
    
    private boolean status = true;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Builder Base (para todas as subclasses)
    public static abstract class Builder<T extends Usuario, B extends Builder<T, B>> {
        protected T instance;

        protected abstract T createInstance();
        protected abstract B self();

        public Builder() {
            this.instance = createInstance();
        }

        public B comNome(String nome) {
            instance.setNome(nome);
            return self();
        }

        public B comEmail(String email) {
            instance.setEmail(email);
            return self();
        }

        public B comStatus(boolean status) {
            instance.setStatus(status);
            return self();
        }

        public T build() {
            // Validação básica
            if (instance.getNome() == null || instance.getEmail() == null) {
                throw new IllegalStateException("Nome e email são obrigatórios");
            }
            return instance;
        }
    }
}
