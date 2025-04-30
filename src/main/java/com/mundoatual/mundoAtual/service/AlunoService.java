package com.mundoatual.mundoAtual.service;

import com.mundoatual.mundoAtual.model.AlunoModel;
import com.mundoatual.mundoAtual.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    @Autowired
    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    // Funcao que define o nivel do aluno com base na idade dele
    public String defineLevel(int age) {
        if(age <= 6) {
            return "Jardim de Infancia";
        } else if(age <= 11) {
            return "Ensino fundamental 1";
        } else if (age <= 15) {
            return "Ensino fundamental 2";
        } else if (age <= 18) {
            return "Ensino Medio";
        } else {
            return "Aluno maior de 18 anos";
        }
    }

    //Metodo para listar todos os alunos que tenho no repository.
    public List<AlunoModel> getAlunos() {
        return repository.findAll();
    }


    //Metodo para criar um aluno e salvar no db.
    public AlunoModel criarAluno(AlunoModel aluno) {
        aluno.setLevel(defineLevel(aluno.getAge()));
        return repository.save(aluno);
    }

    //Metodo para deletar aluno.
    public void deletarAluno(Long id) {
        repository.deleteById(id);
    }

    //Metodo para atualizar os dados cadastrais de um aluno.
    public AlunoModel atualizarAluno(Long id, AlunoModel dadosNovos) {
        Optional<AlunoModel> searchAluno = repository.findById(id);
        if(searchAluno.isPresent()) {
            AlunoModel alunoBuscado = searchAluno.get();

            alunoBuscado.setName(dadosNovos.getName());
            alunoBuscado.setAge(dadosNovos.getAge());
            // Redefine o nivel do aluno
            alunoBuscado.setLevel(defineLevel(dadosNovos.getAge()));
            repository.save(alunoBuscado);
            return  alunoBuscado;
        } else {
            //Se o searchAluno nao estiver presente, trazer um novo erro.
            throw new RuntimeException("Aluno nao encontrado para o id: " + id);
        }
    }
}
