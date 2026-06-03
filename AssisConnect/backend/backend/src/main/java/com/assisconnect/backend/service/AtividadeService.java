package com.assisconnect.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assisconnect.backend.domain.Atividade;
import com.assisconnect.backend.domain.AtividadeRepository;
import com.assisconnect.backend.domain.AtividadeIdosoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private AtividadeIdosoRepository atividadeIdosoRepository;

    public List<Atividade> getAllAtividades() {
        return atividadeRepository.findAllWithResponsavel();
    }

    public Optional<Atividade> getAtividadeById(Long id) {
        return atividadeRepository.findById(id);
    }

    public Atividade createAtividade(Atividade atividade) {

        if (atividade.getResponsavel() == null || atividade.getResponsavel().isBlank()) {
            throw new IllegalArgumentException("Responsável é obrigatório.");
        }
        return atividadeRepository.save(atividade);
    }

    public Optional<Atividade> updateAtividade(Long id, Atividade atividade) {
        if (!atividadeRepository.existsById(id)) return Optional.empty();
        atividade.setId(id);
        return Optional.of(atividadeRepository.save(atividade));
    }

    @Transactional
    public boolean deleteAtividade(Long id) {
        if (!atividadeRepository.existsById(id)) return false;
        // 1. Remove all allocations first to prevent foreign key violations
        atividadeIdosoRepository.deleteAllByAtividadeId(id);
        // 2. Remove the activity itself
        atividadeRepository.deleteById(id);
        return true;
    }
}
