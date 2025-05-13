package com.mundoatual.mundoAtual.controller;


import com.mundoatual.mundoAtual.dtos.TurmaDTO;
import com.mundoatual.mundoAtual.dtos.TurmaRequestDTO;
import com.mundoatual.mundoAtual.model.TurmaModel;
import com.mundoatual.mundoAtual.service.TurmaService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TurmaController {

//    ToDo: deleteMapping(deleteTurmas), Refactor endpoints to use more DTOs, create DTOs for the entity Turma.

    private final TurmaService turmaService;

    @Autowired
    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping("/turma")
    public ResponseEntity<List<TurmaDTO>> getTurmas() {
        List<TurmaDTO> allTurmas = turmaService.getTurmas();
        return ResponseEntity.ok(allTurmas);
    }

    @PostMapping("/turma")
    public ResponseEntity<TurmaDTO> postTurmas(@RequestBody TurmaRequestDTO turma) {
        TurmaModel turmaReceived = turmaService.postTurmas(turma);
        TurmaDTO turmaDTO = new TurmaDTO(turmaReceived);
       return ResponseEntity.ok(turmaDTO);
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
