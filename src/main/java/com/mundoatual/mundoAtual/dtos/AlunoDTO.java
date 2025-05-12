package com.mundoatual.mundoAtual.dtos;

import com.mundoatual.mundoAtual.model.AlunoModel;

public class AlunoDTO {
    private Long id;
    private String name;
    private int age;
    private String level;
    private String turmaName;

    public AlunoDTO(AlunoModel aluno) {
        this.id = aluno.getId();
        this.name = aluno.getName();
        this.age = aluno.getAge();
        this.level = aluno.getLevel();
        this.turmaName = aluno.getTurma() != null ? aluno.getTurma().getName() : null;
    }

    public AlunoDTO() {}

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTurmaName() {
        return turmaName;
    }

    public void setTurmaName(String turmaName) {
        this.turmaName = turmaName;
    }
}
