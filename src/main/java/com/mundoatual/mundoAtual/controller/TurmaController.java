package com.mundoatual.mundoAtual.controller;


import com.mundoatual.mundoAtual.model.TurmaModel;
import com.mundoatual.mundoAtual.service.TurmaService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TurmaController {

//    ToDo: PutMapping(updateTurmas), deleteMapping(deleteTurmas), PostMapping(addNewAluno, to add an aluno to a turma.)

    private final TurmaService turmaService;

    @Autowired
    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping("/turma")
    public ResponseEntity<List<TurmaModel>> getTurmas() {
        List<TurmaModel> allTurmas = turmaService.getTurmas();
        return ResponseEntity.ok(allTurmas);
    }

    @PostMapping("/turma")
    public ResponseEntity<TurmaModel> postTurmas(@RequestBody TurmaModel turma) {
        TurmaModel turmaReceived = turmaService.postTurmas(turma);
       return ResponseEntity.ok(turmaReceived);
    }

    @PutMapping("/turma/{id}")
    public ResponseEntity<TurmaModel> updateTurmas(@PathVariable Long id, @RequestBody TurmaModel newTurma) {
        TurmaModel updatedTurma = turmaService.updateTurmas(id, newTurma);
        return ResponseEntity.ok(updatedTurma);
    }

    @PutMapping("/turma/{id}/aluno/{idAl}")
    public ResponseEntity<TurmaModel> addAlunoToTurma(@PathVariable Long id, @PathVariable Long idAl) {
        TurmaModel turmaWithAluno = turmaService.addAlunoToTurma(id, idAl);
        return ResponseEntity.ok(turmaWithAluno);
    }
}
