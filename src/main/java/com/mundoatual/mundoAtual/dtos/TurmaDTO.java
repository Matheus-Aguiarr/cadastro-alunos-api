package com.mundoatual.mundoAtual.dtos;

import com.mundoatual.mundoAtual.model.AlunoModel;
import com.mundoatual.mundoAtual.model.TurmaModel;

import java.util.List;

public class TurmaDTO {
    private Long id;
    private String name;
    private List<AlunoDTO> alunos;

    public TurmaDTO(TurmaModel turma) {
        this.id = turma.getId();
        this.name = turma.getName();
        this.alunos = turma.getAlunos().stream().map(AlunoDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AlunoDTO> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoDTO> alunos) {
        this.alunos = alunos;
    }
}
