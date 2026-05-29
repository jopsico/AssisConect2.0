package com.assisconnect.backend.service;

import com.assisconnect.backend.domain.Idoso;
import com.assisconnect.backend.domain.IdosoRepository;
import com.assisconnect.backend.domain.Medicamento;
import com.assisconnect.backend.domain.MedicamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicamentoService {

    private final MedicamentoRepository repository;
    private final IdosoRepository idosoRepository;

    public MedicamentoService(MedicamentoRepository repository, IdosoRepository idosoRepository) {
        this.repository = repository;
        this.idosoRepository = idosoRepository;
    }

    @Transactional(readOnly = true)
    public List<Medicamento> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Medicamento> buscarPorResidente(Long residenteId) {
        return repository.findByResidenteId(residenteId);
    }

    @Transactional(readOnly = true)
    public Medicamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicamento não encontrado"));
    }

    public Medicamento salvar(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    public Medicamento criar(Long residenteId, Medicamento med) {
        Idoso idoso = idosoRepository.findById(residenteId)
                .orElseThrow(() -> new RuntimeException("Residente não encontrado"));
        med.setResidente(idoso);
        return repository.save(med);
    }

    public Medicamento atualizar(Long id, Medicamento atualizado) {
        Medicamento existente = buscarPorId(id);

        existente.setNome(atualizado.getNome());
        existente.setDosagem(atualizado.getDosagem());
        existente.setVia(atualizado.getVia());
        existente.setHorarioPrevisto(atualizado.getHorarioPrevisto());
        existente.setStatus(atualizado.getStatus());
        existente.setObservacoes(atualizado.getObservacoes());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
