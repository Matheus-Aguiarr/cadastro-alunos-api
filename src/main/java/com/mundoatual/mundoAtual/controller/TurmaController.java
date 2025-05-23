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

// ToDo: getTurmaById, RemoveAlunoFromTurma
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

    @GetMapping("/turma/{id}")
    public ResponseEntity<TurmaDTO> getTurmaById(@PathVariable Long id) {
        TurmaDTO searchedTurma = turmaService.getTurmaById(id);
        return ResponseEntity.ok(searchedTurma);
    }

    @PostMapping("/turma")
    public ResponseEntity<TurmaDTO> postTurmas(@RequestBody TurmaRequestDTO turma) {
        TurmaModel turmaReceived = turmaService.postTurmas(turma);
        TurmaDTO turmaDTO = new TurmaDTO(turmaReceived);
       return ResponseEntity.ok(turmaDTO);
    }

    @PutMapping("/turma/{id}")
    public ResponseEntity<TurmaDTO> updateTurmas(@PathVariable Long id, @RequestBody TurmaRequestDTO newTurma) {
        TurmaModel updatedTurma = turmaService.updateTurmas(id, newTurma);
        TurmaDTO dto = new TurmaDTO(updatedTurma);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/turma/{id}/aluno/{idAl}")
    public ResponseEntity<TurmaDTO> addAlunoToTurma(@PathVariable Long id, @PathVariable Long idAl) {
        TurmaModel turmaWithAluno = turmaService.addAlunoToTurma(id, idAl);
        TurmaDTO dto = new TurmaDTO(turmaWithAluno);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/turma/{turmaId}/aluno/{alunoId}")
    public ResponseEntity<String> removeAlunoFromTurma(@PathVariable Long turmaId, @PathVariable Long alunoId) {
        return  ResponseEntity.ok(turmaService.deleteAlunoFromTurma(turmaId, alunoId));
    }

    @DeleteMapping("/turma/{id}")
    public ResponseEntity<String> deleteTurmas(@PathVariable Long id) {
        turmaService.deleteTurmas(id);
        return ResponseEntity.ok("Turma com o id: " + id +" deletada com sucesso");
    }
}
