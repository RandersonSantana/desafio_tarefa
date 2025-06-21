package com.lista.tarefa.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private  boolean concluido;

    public Tarefa() {
    }

    public Tarefa(Long id, String nome, String descricao, boolean concluido) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.concluido = concluido;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return concluido == tarefa.concluido && Objects.equals(id, tarefa.id) && Objects.equals(nome, tarefa.nome) && Objects.equals(descricao, tarefa.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, concluido);
    }
}
