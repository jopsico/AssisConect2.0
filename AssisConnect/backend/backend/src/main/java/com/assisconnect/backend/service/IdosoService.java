package com.assisconnect.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.assisconnect.backend.domain.AtividadeIdosoRepository;
import com.assisconnect.backend.domain.Idoso;
import com.assisconnect.backend.domain.IdosoRepository;
import com.assisconnect.backend.domain.User;
import com.assisconnect.backend.domain.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;

@Service
public class IdosoService {

    @Autowired
    private IdosoRepository idosoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AtividadeIdosoRepository atividadeIdosoRepository;

    public Idoso cadastrar(@Valid Idoso idoso) {
        Long idResponsavel = idoso.getResponsavel().getId();
        User responsavel = userRepository.findById(idResponsavel)
            .orElseThrow(() -> new IllegalArgumentException("Usuário responsável não encontrado"));
        idoso.setResponsavel(responsavel);
        return idosoRepository.save(idoso);
    }

    public Page<Idoso> listar(Pageable pageable) {
        return idosoRepository.findAll(pageable);
    }

    public Idoso atualizar(Long id, @Valid Idoso dados) {
    Idoso existente = idosoRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Idoso não encontrado"));

    existente.setNome(dados.getNome());
    existente.setDataNascimento(dados.getDataNascimento());
    existente.setSexo(dados.getSexo());
    existente.setEstadoSaude(dados.getEstadoSaude());
    existente.setObservacoes(dados.getObservacoes());
    existente.setStatus(dados.getStatus());
    existente.setQuarto(dados.getQuarto());

    // só atualiza responsavel se vier válido
    if (dados.getResponsavel() != null && dados.getResponsavel().getId() != null) {
        User responsavel = userRepository.findById(dados.getResponsavel().getId())
            .orElseThrow(() -> new IllegalArgumentException("Usuário responsável não encontrado"));
        existente.setResponsavel(responsavel);
    }

    // 👇 IMPORTANTE: NÃO mexe na foto aqui
    return idosoRepository.save(existente);
}

    public Idoso buscarPorId(Long id) {
        return idosoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Idoso não encontrado"));
    }

    @Transactional
    public void remover(Long id) {
        Idoso idoso = idosoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Idoso não encontrado"));
        
        // Remove todos os vínculos do idoso na tabela atividade_idoso antes de excluí-lo
        atividadeIdosoRepository.deleteByIdoso(idoso);
        
        // Remove o idoso da tabela principal
        idosoRepository.delete(idoso);
    }

    public long countAll() {
        return idosoRepository.count();
    }

    public List<Idoso> findAniversariantesDeHoje() {
        return idosoRepository.findAniversariantesDeHoje();
    }
}
