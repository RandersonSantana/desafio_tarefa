package com.lista.tarefa.controllers;

import com.lista.tarefa.dtos.TarefaDTO;
import com.lista.tarefa.models.Tarefa;
import com.lista.tarefa.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @PostMapping()
    public  ResponseEntity<TarefaDTO> cadastrarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO tarefa = tarefaService.cadastrarTarefa(tarefaDTO);
        return ResponseEntity.ok(tarefa);
    }

    @GetMapping
    public  ResponseEntity<List<TarefaDTO>> listarTodasTarefas(){
        return ResponseEntity.ok(tarefaService.listarTodasTarefas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> buscarTarefaPorId(@PathVariable Long id){
        return  ResponseEntity.ok(tarefaService.buscarTarefaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO){
        return ResponseEntity.ok(tarefaService.atualizarTarefa(id, tarefaDTO));
    }
    @DeleteMapping()
    public ResponseEntity<Void> deletarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        tarefaService.deletarTarefa(tarefaDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
