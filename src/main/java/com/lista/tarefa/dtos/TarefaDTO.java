package com.lista.tarefa.dtos;

import jakarta.persistence.Column;

public class TarefaDTO {
    private Long id;
    private String nome;
    private String descricao;
    private  boolean concluido;

    public TarefaDTO() {
    }

    public TarefaDTO(Long id, String nome, String descricao, boolean concluido) {
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
}
