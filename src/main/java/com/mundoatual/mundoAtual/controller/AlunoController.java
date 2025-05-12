package com.mundoatual.mundoAtual.controller;

import com.mundoatual.mundoAtual.dtos.AlunoDTO;
import com.mundoatual.mundoAtual.dtos.AlunoRequestDTO;
import com.mundoatual.mundoAtual.model.AlunoModel;
import com.mundoatual.mundoAtual.service.AlunoService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/aluno")
    public ResponseEntity<List<AlunoDTO>> getAluno() {
        List<AlunoModel> alunos = alunoService.getAlunos();
        List<AlunoDTO> alunoDTOs = alunos.stream().map(AlunoDTO::new).toList();

        return ResponseEntity.ok(alunoDTOs);
    }

    @GetMapping("/aluno/{id}")
    public ResponseEntity<AlunoDTO> getAlunoById(@PathVariable Long id) {
        AlunoDTO searchAluno = alunoService.getAlunoById(id);
        return ResponseEntity.ok(searchAluno);
    }

    @PostMapping("/aluno")
    public ResponseEntity<String> criarAluno(@RequestBody AlunoRequestDTO dto) {
        System.out.println("Recebido: " + dto);
        AlunoModel alunoSalvo = alunoService.criarAluno(dto);
        return ResponseEntity.ok("Aluno Criado com sucesso: " + alunoSalvo);
    }

    @DeleteMapping("/aluno/{id}")
    public ResponseEntity<String> deletarAluno(@PathVariable Long id) {
        try {
            alunoService.deletarAluno(id);
            return ResponseEntity.ok("Aluno com o ID: " + id + " deletado com sucesso!");
        } catch(EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERRO AO DELETAR ALUNO: " + e.getMessage());
        }
    }

    @PutMapping("/aluno/{id}")
    public ResponseEntity<String> atualizarAluno(@PathVariable Long id, @RequestBody AlunoDTO dadosNovos) {
        AlunoModel alunoAtualizado = alunoService.atualizarAluno(id, dadosNovos); //Aluno atualizado
        return ResponseEntity.ok("Aluno Atualizado com sucesso: " + alunoAtualizado);//Quero imprimir ele aqui
    }
}
