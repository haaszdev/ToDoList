package com.todolist.todohaas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class todoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDateTime datacriacao;
    private LocalDateTime dataatualizacao;
    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(LocalDateTime datacriacao) {
        this.datacriacao = datacriacao;
    }

    public LocalDateTime getDataatualizacao() {
        return dataatualizacao;
    }

    public void setDataatualizacao(LocalDateTime dataatualizacao) {
        this.dataatualizacao = dataatualizacao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        todoModel todo = (todoModel) o;
        return status == todo.status && Objects.equals(id, todo.id) && Objects.equals(descricao, todo.descricao) && Objects.equals(datacriacao, todo.datacriacao) && Objects.equals(dataatualizacao, todo.dataatualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, datacriacao, dataatualizacao, status);
    }
}
