package com.lista.tarefa.dtos;

import jakarta.persistence.Column;

public class TarefaDTO {
    private Long id;
    private String descricao;
    private  boolean concluido;

    public TarefaDTO() {
    }

    public TarefaDTO(Long id, String descricao, boolean concluido) {
        this.id = id;
        this.descricao = descricao;
        this.concluido = concluido;
    }

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

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
