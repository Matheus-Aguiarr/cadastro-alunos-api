package com.mundoatual.mundoAtual.service;

import com.mundoatual.mundoAtual.dtos.AlunoDTO;
import com.mundoatual.mundoAtual.dtos.AlunoRequestDTO;
import com.mundoatual.mundoAtual.model.AlunoModel;
import com.mundoatual.mundoAtual.model.TurmaModel;
import com.mundoatual.mundoAtual.repository.AlunoRepository;
import com.mundoatual.mundoAtual.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
//    ToDo: Refactor if and else of the methods to use orElseThrow efficiently
    private final AlunoRepository repository;
    private final TurmaRepository turmaRepository;

    @Autowired
    public AlunoService(AlunoRepository repository, TurmaRepository turmaRepository) {
        this.repository = repository;
        this.turmaRepository = turmaRepository;
    }

    // Funcao que define o nivel do aluno com base na idade dele
    public String defineLevel(int age) {
        if(age <= 6) {
            return "Jardim de Infância";
        } else if(age <= 11) {
            return "Ensino fundamental 1";
        } else if (age <= 15) {
            return "Ensino fundamental 2";
        } else if (age <= 18) {
            return "Ensino Médio";
        } else {
            return "Aluno maior de 18 anos";
        }
    }

    //Metodo para listar todos os alunos que tenho no repository.
    public List<AlunoModel> getAlunos() {
        return repository.findAll();
    }

    public AlunoDTO getAlunoById(Long id) {
        AlunoModel aluno = repository.findById(id).orElseThrow(() -> new RuntimeException("Aluno nao encontrado"));
        AlunoDTO dto;
        return dto = new AlunoDTO(aluno);
    }


    //Metodo para criar um aluno e salvar no db.
    public AlunoModel criarAluno(AlunoRequestDTO dto) {
        AlunoModel aluno = new AlunoModel();
        aluno.setName(dto.getName());
        aluno.setAge(dto.getAge());
        aluno.setLevel(defineLevel(dto.getAge()));

        TurmaModel turma = turmaRepository.findById(dto.getTurmaId()).orElseThrow(() -> new RuntimeException("Turma nao encontrada"));
        aluno.setTurma(turma);

        return repository.save(aluno);
    }

    //Metodo para deletar aluno.
    public void deletarAluno(Long id) {
        repository.deleteById(id);
    }

    //Metodo para atualizar os dados cadastrais de um aluno.
    public AlunoModel atualizarAluno(Long id, AlunoDTO dto) {
        Optional<AlunoModel> searchAluno = repository.findById(id);
        TurmaModel turma = turmaRepository.findByName(dto.getTurmaName()).orElseThrow(() -> new RuntimeException("Turma nao encontrada"));
        if(searchAluno.isPresent()) {
            AlunoModel alunoBuscado = searchAluno.get();
            alunoBuscado.setName(dto.getName());
            alunoBuscado.setAge(dto.getAge());
            // Redefine o nivel do aluno
            alunoBuscado.setLevel(defineLevel(dto.getAge()));
            alunoBuscado.setTurma(turma);
            repository.save(alunoBuscado);
            return  alunoBuscado;
        } else {
            //Se o searchAluno nao estiver presente, trazer um novo erro.
            throw new RuntimeException("Aluno nao encontrado para o id: " + id);
        }
    }
}
