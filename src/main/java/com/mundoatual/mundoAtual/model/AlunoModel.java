package com.mundoatual.mundoAtual.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Cria a Entidade Aluno
@Entity
@Table(name = "aluno")
@Getter
@Setter
@AllArgsConstructor
public class AlunoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id") //Serve para garantir que o spring vai conseguir ler o JSON corretamente e nao entregar valores nulos
    private long id;
    @JsonProperty("age")
    private int age;
    @JsonProperty("name")
    private String name;
    @JsonProperty("level")
    private String level;

    public AlunoModel() {}

    public AlunoModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{\nAluno: " + this.name + "\nAge: " + this.age + "\nLevel: " + this.level + "\n}" + this.id;
    }
}
