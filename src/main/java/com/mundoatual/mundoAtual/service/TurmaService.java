package com.mundoatual.mundoAtual.service;

import com.mundoatual.mundoAtual.dtos.AlunoDTO;
import com.mundoatual.mundoAtual.dtos.TurmaDTO;
import com.mundoatual.mundoAtual.dtos.TurmaRequestDTO;
import com.mundoatual.mundoAtual.model.AlunoModel;
import com.mundoatual.mundoAtual.model.TurmaModel;
import com.mundoatual.mundoAtual.repository.AlunoRepository;
import com.mundoatual.mundoAtual.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;

    @Autowired
    public TurmaService(TurmaRepository turmaRepository, AlunoRepository alunoRepository) {
        this.turmaRepository = turmaRepository;
        this.alunoRepository = alunoRepository;
    }

    public List<TurmaDTO> getTurmas() {
        List<TurmaModel> turmaModels = turmaRepository.findAll();
        List<TurmaDTO> dtos = turmaModels.stream().map(TurmaDTO::new).toList();
        return dtos;
    }

    public TurmaModel postTurmas(TurmaRequestDTO dto) {
        TurmaModel turmaSave = new TurmaModel();
        turmaSave.setName(dto.getName());
        return turmaRepository.save(turmaSave);
    }

    public TurmaModel updateTurmas(Long id, TurmaRequestDTO dto) {
        Optional<TurmaModel> searchTurma = turmaRepository.findById(id);

        if (searchTurma.isPresent()) {
            TurmaModel searchedTurma = searchTurma.get(); //Pega os dados da turma buscada
            searchedTurma.setName(dto.getName()); //Passa o name dos novos dados para a turma buscada
            turmaRepository.save(searchedTurma);
            return searchedTurma;
        } else {
            throw new RuntimeException("Turma nao encontrada para o id: " + id);
        }
    }

    public TurmaModel addAlunoToTurma(Long id, Long idAl) {
        Optional<TurmaModel> searchTurma = turmaRepository.findById(id);
        Optional<AlunoModel> searchAluno = alunoRepository.findById(idAl);

        if(searchTurma.isPresent() && searchAluno.isPresent()) {
            TurmaModel searchedTurma = searchTurma.get();
            AlunoModel searchedAluno = searchAluno.get();
            if(!searchedTurma.getAlunos().contains(searchedAluno)) { //se a lista ja nao conter o aluno buscado
                searchedTurma.getAlunos().add(searchedAluno);
            }
             //ADD o aluno buscado a lista de alunos da Turma.
            searchedAluno.setTurma(searchedTurma); //Automaticamente seto que a turma do aluno buscado, eh a turma buscada

            alunoRepository.save(searchedAluno);
            return turmaRepository.save(searchedTurma);
        } else {
            throw new RuntimeException("Turma ou aluno nao encontrados");
        }
    }
}
