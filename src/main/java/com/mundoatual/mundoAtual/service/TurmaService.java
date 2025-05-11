package com.mundoatual.mundoAtual.service;

import com.mundoatual.mundoAtual.model.TurmaModel;
import com.mundoatual.mundoAtual.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    @Autowired
    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<TurmaModel> getTurmas() {
        return turmaRepository.findAll();
    }

    public TurmaModel postTurmas(TurmaModel turma) {
        return turmaRepository.save(turma);
    }
}
