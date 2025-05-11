package com.mundoatual.mundoAtual.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "turma")
public class TurmaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    //One se referencia a classe, e Many se referencia ao atributo
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    @JsonProperty("alunos")
    private List<AlunoModel> alunos = new ArrayList<>();

    public TurmaModel() {}

    public TurmaModel(String name, List<AlunoModel> alunos) {
        this.name = name;
        this.alunos = alunos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AlunoModel> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoModel> alunos) {
        this.alunos = alunos;
    }
}
