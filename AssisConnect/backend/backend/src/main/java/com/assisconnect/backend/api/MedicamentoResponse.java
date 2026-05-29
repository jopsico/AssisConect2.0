package com.assisconnect.backend.api;

import com.assisconnect.backend.domain.Medicamento;

public class MedicamentoResponse {
    private Long id;
    private String nome;
    private String dosagem;
    private String via;
    private Long residenteId;
    private String residenteNome;
    private String horarioPrevisto;
    private String status;
    private String observacoes;

    public MedicamentoResponse() {}

    public MedicamentoResponse(Medicamento med) {
        this.id = med.getId();
        this.nome = med.getNome();
        this.dosagem = med.getDosagem();
        this.via = med.getVia();
        if (med.getResidente() != null) {
            this.residenteId = med.getResidente().getId();
            this.residenteNome = med.getResidente().getNome();
        }
        this.horarioPrevisto = med.getHorarioPrevisto();
        this.status = med.getStatus();
        this.observacoes = med.getObservacoes();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDosagem() { return dosagem; }
    public void setDosagem(String dosagem) { this.dosagem = dosagem; }

    public String getVia() { return via; }
    public void setVia(String via) { this.via = via; }

    public Long getResidenteId() { return residenteId; }
    public void setResidenteId(Long residenteId) { this.residenteId = residenteId; }

    public String getResidenteNome() { return residenteNome; }
    public void setResidenteNome(String residenteNome) { this.residenteNome = residenteNome; }

    public String getHorarioPrevisto() { return horarioPrevisto; }
    public void setHorarioPrevisto(String horarioPrevisto) { this.horarioPrevisto = horarioPrevisto; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
