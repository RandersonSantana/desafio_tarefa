package com.lista.tarefa.services;

import com.lista.tarefa.dtos.TarefaDTO;
import com.lista.tarefa.exceptions.BussinesException;
import com.lista.tarefa.models.Tarefa;
import com.lista.tarefa.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {
    private static final String MSG_TAREFA = "Tarefa não encontrado";

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaDTO  converterTarefaParaTarefaDTO(Tarefa tarefa){
        TarefaDTO tarefaDTO = new TarefaDTO(tarefa.getId(),
                tarefa.getDescricao(),
                tarefa.isConcluido());
        return tarefaDTO;
    }
    public Tarefa converterTarefaDTOParaTarefa(TarefaDTO tarefaDTO){
        Tarefa tarefa = new Tarefa(tarefaDTO.getId(),
                tarefaDTO.getDescricao(),
                tarefaDTO.isConcluido());
        return tarefa;
    }
    public TarefaDTO cadastrarTarefa(TarefaDTO tarefaDTO){
        Tarefa tarefa = converterTarefaDTOParaTarefa(tarefaDTO);
        tarefa = tarefaRepository.save(tarefa);
        return converterTarefaParaTarefaDTO(tarefa);
    }
    public TarefaDTO atualizarTarefa(Long id, TarefaDTO tarefaDTO){
        tarefaRepository.findById(id)
                .orElseThrow(() -> new BussinesException(MSG_TAREFA));

        Tarefa tarefa = converterTarefaDTOParaTarefa(tarefaDTO);
        tarefaRepository.save(tarefa);
        return converterTarefaParaTarefaDTO(tarefa);
    }
    public List<TarefaDTO> listarTodasTarefas(){
        List<Tarefa> tarefas = tarefaRepository.findAll();
        List<TarefaDTO> tarefaDTOs = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            tarefaDTOs.add(converterTarefaParaTarefaDTO(tarefa));
        }
        return tarefaDTOs;
    }
    public TarefaDTO buscarTarefaPorId(Long id){
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new BussinesException(MSG_TAREFA));
        return converterTarefaParaTarefaDTO(tarefa);
    }
    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }
}
