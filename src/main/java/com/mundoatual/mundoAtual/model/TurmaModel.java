package com.mundoatual.mundoAtual.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "turma")
public class TurmaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("name")
    private String name;

    //One se referencia a classe, e Many se referencia ao atributo
    @OneToMany(mappedBy = "turma")
    @JsonProperty("alunos")
    private AlunoModel alunos;

    public TurmaModel() {}

    public TurmaModel(String name, AlunoModel alunos) {
        this.name = name;
        this.alunos = alunos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AlunoModel getAlunos() {
        return alunos;
    }

    public void setAlunos(AlunoModel alunos) {
        this.alunos = alunos;
    }


}
