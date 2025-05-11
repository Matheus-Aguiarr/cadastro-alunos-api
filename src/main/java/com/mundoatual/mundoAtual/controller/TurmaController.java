package com.mundoatual.mundoAtual.controller;


import com.mundoatual.mundoAtual.model.TurmaModel;
import com.mundoatual.mundoAtual.service.TurmaService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TurmaController {


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
}
